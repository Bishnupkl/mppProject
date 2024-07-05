package Business.Book;

import Business.Checkout.CheckoutRecord;
import Business.HelperFactory;
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

    public int getBorrowDuration() {
        return borrowDuration;
    }
    public String getTitle() {return this.title;}

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
            return HelperFactory.generateStatusInfo(false, null, MessageConstant.BOOK_NOT_FOUND);
        } else {
            return HelperFactory.generateStatusInfo(true, book, null);
        }
    }

    public static StatusInfoWrapper addBook(String newIsbn, String newTitle, int newBorrowDuration, List<Author> newAuthors,int copies) {
        StatusInfoWrapper result = checkBookExist(newIsbn);
        if (result.getStatus() == false) {
            Book newBook = new Book(newIsbn, newTitle, newBorrowDuration, newAuthors);
            BookDataAccess.createNewBook(newBook);
            int tmp=0;
            while (tmp<copies){
                Book.addCopy(newBook.getIsbn());
                tmp++;
            }
            return HelperFactory.generateStatusInfo(true, null, "Create Book Successful");
        } else {
            return HelperFactory.generateStatusInfo(false, null, "Book already exist in the system");
        }
    }

    public static StatusInfoWrapper addCopy(String newIsbn) {
        StatusInfoWrapper result = checkBookExist(newIsbn);
        if (result.getStatus()) {
            Book book = (Book) result.getValue();
            book.setBookCopies(new BookCopy(book));
            BookDataAccess.createNewBookCopy(book);
            return HelperFactory.generateStatusInfo(true, null, "Add Copy Successful");
        }
        return HelperFactory.generateStatusInfo(true, null, "Cannot add copy");
    }

    public static List<BookCopy> getBookCopies(String isbn) {

        StatusInfoWrapper result = checkBookExist(isbn);
        if (result.getStatus()) {
            return ((Book) result.getValue()).getBookCopies();
        }

        return null;
    }

    public void setBookCopies(BookCopy bookCopy) {
        this.bookCopies.add(bookCopy);
    }

    public static StatusInfoWrapper getAvailableCopy(String isbn) {
        Book book = BookDataAccess.readBook(isbn);
        if (book == null) {
            return HelperFactory.generateStatusInfo(false, null, "Book does not exist in system");
        } else {
            List<BookCopy> copies = book.getBookCopies();
            for (BookCopy copy : copies) {
                if (copy.getCheckoutRecord() == null) {
                    return HelperFactory.generateStatusInfo(true, copy, "success");
                } else if (copy.getCheckoutRecord().getReturnDate() != null) {
                    return HelperFactory.generateStatusInfo(true, copy, "success");
                }
            }
            return HelperFactory.generateStatusInfo(false, null, "No Copy available");
        }
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public static void addCheckoutRecord(CheckoutRecord checkoutRecord)
    {
        BookDataAccess.addCheckoutRecord(checkoutRecord);
    }



}
