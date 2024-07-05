package Business.Person;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Checkout.CheckoutRecord;
import Business.Checkout.CheckoutRecordFactory;
import Business.MessageConstant;
import Business.StatusInfoWrapper;
import DataAccess.MemberDataAccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member extends Person {
    private String memberId;
    private List<CheckoutRecord> checkoutRecords = new ArrayList<>();

    private Member(String memberId, String firstName, String lastName, String telephone, Address address)
    {
        super(firstName, lastName, telephone, address);
        this.memberId = memberId;
    }

    public static Member addMember(String memberId, String firstName, String lastName, String street, String city, String state, String zip, String telephone)
    {
        Address address = new Address(street, city, state, zip);
        Member member = new Member(memberId, firstName, lastName, telephone, address);
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

        Member member = (Member)memberResult.getValue();
        Book book = (Book)bookResult.getValue();
        CheckoutRecord checkoutRecord = CheckoutRecordFactory.createCheckoutRecord(member, new BookCopy(null));

        MemberDataAccess.addCheckoutRecord(checkoutRecord);
        return new StatusInfoWrapper(true, null, null);

    }

    private static StatusInfoWrapper checkMemberExists(String memberId)
    {
        Member member = MemberDataAccess.readMember(memberId);
        if(member == null)
        {
            return new StatusInfoWrapper(false, null, MessageConstant.MEMBER_NOT_FOUND);
        }
        else {
            return new StatusInfoWrapper(true, member, null);
        }
    }

    public String getId() {
        return this.memberId;
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
