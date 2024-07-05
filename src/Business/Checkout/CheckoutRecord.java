package Business.Checkout;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Person.Member;

import java.io.Serializable;

public class CheckoutRecord implements Serializable {
    private BookCopy bookCopy;
    private Member member;

    public Member getMember() {
        return member;
    }

    CheckoutRecord(Member member, BookCopy bookCopy)
    {
        this.member = member;
        this.bookCopy = bookCopy;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }
}
