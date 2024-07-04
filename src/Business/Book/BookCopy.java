package Business.Book;

import java.io.Serializable;

public class BookCopy implements Serializable {

    private String id;
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
}
