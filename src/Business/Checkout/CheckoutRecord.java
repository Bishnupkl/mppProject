package Business.Checkout;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Person.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class CheckoutRecord implements Serializable {
    private BookCopy bookCopy;
    private Member member;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Member getMember() {
        return member;
    }

    CheckoutRecord(Member member, BookCopy bookCopy)
    {
        this.member = member;
        this.bookCopy = bookCopy;
        this.checkoutDate = LocalDate.now();
        this.dueDate = LocalDate.now().plus(Period.ofDays(bookCopy.getBook().getBorrowDuration()));
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }
}
