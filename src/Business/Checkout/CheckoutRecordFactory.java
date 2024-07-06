package Business.Checkout;

import Business.Book.BookCopy;
import Business.Person.Member;

public final class CheckoutRecordFactory {
    private CheckoutRecordFactory(){}
    public static CheckoutRecord generateCheckoutRecord(Member member, BookCopy bookCopy)
    {
        return new CheckoutRecord(member, bookCopy);
    }
}
