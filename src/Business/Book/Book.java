package Business.Book;

import Business.MessageConstant;
import Business.Person.Address;
import Business.Person.Author;
import Business.Person.Member;
import Business.StatusInfoWrapper;
import DataAccess.BookDataAccess;
import DataAccess.MemberDataAccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    private String isbn;
    private String title;
    private int borrowDuration;
    private List<BookCopy> bookCopies = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    private Book(String newIsbn, String newTitle, int newBorrowDuration, Author newAuthor) {
        this.isbn = newIsbn;
        this.title = newTitle;
        this.borrowDuration = newBorrowDuration;
        BookCopy copyOne = new BookCopy(this);
        this.bookCopies.add(copyOne);
        newAuthor.setBook(this);
        this.authors.add(newAuthor);
    }

    private Book(String newIsbn, String newTitle, int newBorrowDuration, List<Author> newAuthors) {
        this.isbn = newIsbn;
        this.title = newTitle;
        this.borrowDuration = newBorrowDuration;
        BookCopy copyOne = new BookCopy(this);
        this.bookCopies.add(copyOne);
        for (Author a : newAuthors) {
            a.setBook(this);
        }
        this.authors.addAll(newAuthors);
    }

    public String getIsbn() {
        return isbn;
    }

    public static StatusInfoWrapper checkBookExist(String isbn) {
        Book book = BookDataAccess.readBook(isbn);
        if (book == null) {
            return new StatusInfoWrapper(false, null, MessageConstant.BOOK_NOT_FOUND);
        } else {
            return new StatusInfoWrapper(true, book, null);
        }
    }

    public static StatusInfoWrapper addBook(String newIsbn, String newTitle, int newBorrowDuration, List<Author> newAuthors) {
        Book newBook = new Book(newIsbn, newTitle, newBorrowDuration, newAuthors);
        StatusInfoWrapper result = checkBookExist(newBook.getIsbn());
        System.out.println(result.getValue());
        if (result.getStatus() == false) {
            BookDataAccess.createNewBook(newBook);
            return new StatusInfoWrapper(true, null, "Create Book Successful");
        } else {
            return new StatusInfoWrapper(false, null, "Book already exist in the system");
        }
    }

    public static StatusInfoWrapper addCopy(String newIsbn) {
        StatusInfoWrapper result = checkBookExist(newIsbn);
        System.out.println(result.getStatus());
        if (result.getStatus()) {
            Book book = (Book) result.getValue();
            book.setBookCopies(new BookCopy(book));
            BookDataAccess.createNewBookCopy(book);
            return new StatusInfoWrapper(true, null, "Add Copy Successful");
        }
        return new StatusInfoWrapper(true, null, "Cannot add copy");
    }

    public static List<BookCopy> getBookCopies(String isbn) {

        StatusInfoWrapper result = checkBookExist(isbn);
        if (result.getStatus()) {
            return ((Book) result.getValue()).getBookCopies();
        }

        return null;
    }

    public static void main(String[] args) {
//        Address address= new Address("4th","fairfield","IOWA","52556");
//        Author author= new Author("John","Cena","641222333",address,"Good Author","Nice Author");
//        Book.addBook(new Book("How to","13",7,author));
//        Book.addCopy("11");
//        List<BookCopy> copies = Book.getBookCopies("How to");
    }

    public void setBookCopies(BookCopy bookCopy) {
        this.bookCopies.add(bookCopy);
    }

    public StatusInfoWrapper getAvailableCopy(String isbn) {
        Book book = BookDataAccess.readBook(isbn);
        if (book == null) {
            return new StatusInfoWrapper(false, null, "Book does not exist in system");
        } else {
            List<BookCopy> copies = book.getBookCopies();
            for (BookCopy copy : copies) {
                if (copy.getCheckoutRecord().equals(null)) {
                    return new StatusInfoWrapper(true, copy, "success");
                } else if (!copy.getCheckoutRecord().getReturnDate().equals(null)) {
                    return new StatusInfoWrapper(true, copy, "success");
                }
            }
            return new StatusInfoWrapper(false, null, "No Copy available");
        }
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }
}
