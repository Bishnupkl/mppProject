package Business.Person;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Checkout.CheckoutRecord;
import Business.Checkout.CheckoutRecordFactory;
import Business.HelperFactory;
import Business.MessageConstant;
import Business.StatusInfoWrapper;
import DataAccess.MemberDataAccess;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
    private String memberId;
    private List<CheckoutRecord> checkoutRecords = new ArrayList<>();

    Member(String memberId, String firstName, String lastName, String telephone, Address address)
    {
        super(firstName, lastName, telephone, address);
        this.memberId = memberId;
    }

    public String getId() {
        return this.memberId;
    }

    public static Member addMember(String memberId, String firstName, String lastName, String street, String city, String state, String zip, String telephone)
    {
        Member member = PersonFactory.generateMember(memberId, firstName, lastName, street, city, state, zip, telephone);
        MemberDataAccess.addMember(member);
        return member;
    }

    public static StatusInfoWrapper checkout(String memberId, String isbn)
    {
        StatusInfoWrapper memberResult = checkMemberExists(memberId);
        if(memberResult.getStatus() == false)
        {
            return memberResult;
        }

        StatusInfoWrapper bookResult = Book.checkBookExist(isbn);
        if(bookResult.getStatus() == false)
        {
            return bookResult;
        }

        StatusInfoWrapper bookCopyResult = Book.getAvailableCopy(isbn);
        if(bookCopyResult.getStatus() ==  false)
        {
            return bookCopyResult;
        }

        Member member = (Member)memberResult.getValue();
        BookCopy bookCopy = (BookCopy)bookCopyResult.getValue();
        CheckoutRecord checkoutRecord = CheckoutRecordFactory.generateCheckoutRecord(member, bookCopy);

        Member updatedMember = MemberDataAccess.addCheckoutRecord(checkoutRecord);
        Book.addCheckoutRecord(checkoutRecord);


        return HelperFactory.generateStatusInfo(true, updatedMember, null);
    }

    private static StatusInfoWrapper checkMemberExists(String memberId)
    {
        Member member = MemberDataAccess.readMember(memberId);
        if(member == null)
        {
            return HelperFactory.generateStatusInfo(false, null, MessageConstant.MEMBER_NOT_FOUND);
        }
        else {
            return HelperFactory.generateStatusInfo(true, member, null);
        }
    }


    public static Member getMember(String id) {
        return MemberDataAccess.readMember(id);
    }

    public List<CheckoutRecord> getCheckoutRecords() {
        return this.checkoutRecords;
    }

    public void setCheckoutRecords(List<CheckoutRecord> checkoutRecords)
    {
        this.checkoutRecords = checkoutRecords;
    }
}
