package Business.Person;

import Business.Checkout.CheckoutRecord;
import DataAccess.PersonDataAccess;

import java.util.Collections;
import java.util.List;

public class Member extends Person {
    private List<CheckoutRecord> checkoutRecords;

    public Member(){ 
      super ("", "");
    }

    public static Member getMember(String id) {
        Person foundPerson =  PersonDataAccess.readPerson(id);
        if (!(foundPerson instanceof Member)) {
            return null;
        }
        return (Member)foundPerson;
    }

    public List<CheckoutRecord> getCheckoutRecords() {
        return Collections.unmodifiableList(this.checkoutRecords);
    }
}
