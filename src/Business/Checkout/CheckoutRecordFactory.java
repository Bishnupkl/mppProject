package Business.Checkout;

import Business.Book.BookCopy;
import Business.Person.Member;

public class CheckoutRecordFactory {
    private CheckoutRecordFactory(){}
    public static CheckoutRecord createCheckoutRecord(Member member, BookCopy bookCopy)
    {
        return new CheckoutRecord(member, bookCopy);
    }
}
