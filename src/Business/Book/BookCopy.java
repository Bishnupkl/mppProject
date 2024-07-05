package Business.Book;

import Business.Checkout.CheckoutRecord;

import java.io.Serializable;

public class BookCopy implements Serializable {

    private String id;
    private Book book;

    private CheckoutRecord checkoutRecord;
    public BookCopy(Book newBook){
        this.id= String.valueOf(Math.random());
        this.book= newBook;
    }

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "id='" + id +
                '}';
    }
}
