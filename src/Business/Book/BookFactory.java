package Business.Book;

import Business.Person.Author;

import java.util.List;

public class BookFactory {
    private BookFactory(){}
    public static Book generateBook(String newIsbn, String newTitle, int newBorrowDuration, List<Author> newAuthors){
        return new Book(newIsbn, newTitle, newBorrowDuration, newAuthors);
    }
    public static BookCopy generateBookCopy(Book book){
        return new BookCopy(book);
    }
}
