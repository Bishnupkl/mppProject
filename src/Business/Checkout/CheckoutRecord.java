package Business.Checkout;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Person.Member;

import java.io.Serializable;
import java.util.Date;

public class CheckoutRecord implements Serializable {
    private BookCopy bookCopy;
    private Member member;

    private Date returnDate;

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Member getMember() {
        return member;
    }

    CheckoutRecord(Member member, BookCopy bookCopy)
    {
        this.member = member;
        this.bookCopy = bookCopy;
    }
}
