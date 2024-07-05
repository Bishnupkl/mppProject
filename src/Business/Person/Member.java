package Business.Person;

import Business.Checkout.CheckoutRecord;
import DataAccess.MemberDataAccess;
import DataAccess.PersonDataAccess;

import java.util.Collections;
import java.util.List;

public class Member extends Person {
    private String memberId;
    private List<CheckoutRecord> checkoutRecords;
    private Member(String memberId, String firstName, String lastName, String telephone, Address address)
    {        
        super(firstName, lastName, telephone, address);
        this.memberId = memberId;
    }

    public static Member addMember(String memberId, String firstName, String lastName, String street, String city, String state, int zip, String telephone)
    {
        Address address = new Address(street, city, state, zip);
        Member member = new Member(memberId, firstName, lastName, telephone, address);
        PersonDataAccess.addPerson(member);
        return member;
    }

    public String getId() {
        return this.memberId;
    }

    public static Member getMember(String id) {
        return MemberDataAccess.readMember(id);
    }

    public List<CheckoutRecord> getCheckoutRecords() {
        return Collections.unmodifiableList(this.checkoutRecords);
    }
}
