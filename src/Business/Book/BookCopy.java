package Business.Book;

import Business.Checkout.CheckoutRecord;

import java.io.Serializable;

public class BookCopy implements Serializable {

    private String id;
    private CheckoutRecord checkoutRecord;

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }

    public String getId() {
        return id;
    }

    private Book book;

    public BookCopy(Book newBook){
        this.id= String.valueOf(Math.random());
        this.book= newBook;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "id='" + id +
                '}';
    }

    public Book getBook() {
        return book;
    }
}
