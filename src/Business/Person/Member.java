package Business.Person;

import Business.Checkout.CheckoutRecord;
import DataAccess.MemberDataAccess;

import java.util.Collections;
import java.util.List;

public class Member extends Person {
    private final String id;
    private List<CheckoutRecord> checkoutRecords;

    public Member(String id)
    {
        super("","");
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public static Member getMember(String id) {
        return MemberDataAccess.readMember(id);
    }

    public List<CheckoutRecord> getCheckoutRecords() {
        return Collections.unmodifiableList(this.checkoutRecords);
    }
}
