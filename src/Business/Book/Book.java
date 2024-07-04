package Business.Book;

import Business.Person.Address;
import Business.Person.Author;
import DataAccess.BookDataAccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    private String isbn;
    private String title;
    private int borrowDuration;
    private List<BookCopy> bookCopies = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public Book(String newIsbn, String newTitle, int newBorrowDuration,Author newAuthor) {
        this.isbn = newIsbn;
        this.title = newTitle;
        this.borrowDuration=newBorrowDuration;
        BookCopy copyOne = new BookCopy(this);
        this.bookCopies.add(copyOne);
        newAuthor.setBook(this);
        this.authors.add(newAuthor);
    }

    public Book(String newIsbn, String newTitle, int newBorrowDuration,List<Author> newAuthors) {
        this.isbn = newIsbn;
        this.title = newTitle;
        this.borrowDuration=newBorrowDuration;
        BookCopy copyOne = new BookCopy(this);
        this.bookCopies.add(copyOne);
        for (Author a:newAuthors){
            a.setBook(this);
        }
        this.authors.addAll(newAuthors);
    }

    public String getIsbn() {
        return isbn;
    }

    public static boolean checkBookExist(String isbn) {
        BookDataAccess bda = new BookDataAccess();
        List<Book> dbBooks = bda.readBooks();
        for (Book b : dbBooks) {
            if (b.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public static void addBook(Book newBook) {
        if (!checkBookExist(newBook.getIsbn())) {
            BookDataAccess bda = new BookDataAccess();
            List<Book> dbBooks = bda.readBooks();
            dbBooks.add(newBook);
            bda.write("book.bin",dbBooks);
            System.out.printf("Add Book Success");
            return;
        }
        System.out.printf("Book exist");
    }

    public static void addCopy(String newIsbn) {
        if (checkBookExist(newIsbn)) {
            List<Book> dbBooks = BookDataAccess.readBooks();
            for (Book b:dbBooks){
                if(b.getIsbn().equals(newIsbn)){
                    b.setBookCopies(new BookCopy(b));
                }
            }
            BookDataAccess.createNewBook(dbBooks);
            System.out.printf("Add BookCopy Success");
            return;
        }
        System.out.printf("Book does not exist please create book");
    }

    public static List<BookCopy> getBookCopies(String isbn){
        if (checkBookExist(isbn)) {
            List<Book> dbBooks = BookDataAccess.readBooks();
            for (Book b:dbBooks){
                if(b.getIsbn().equals(isbn)){
                    for (BookCopy copy: b.getBookCopies()){
                        System.out.println(copy);
                    }
                    return b.getBookCopies();
                }
            }
        }
        System.out.printf("Book does not exist");
        return null;
    }

    public static void main(String[] args) {
//        Address address= new Address("4th","fairfield","IOWA","52556");
//        Author author= new Author("John","Cena","641222333",address,"Good Author","Nice Author");
//        Book.addBook(new Book("How to","13",7,author));
//        Book.addCopy("How to");
//        List<BookCopy> copies = Book.getBookCopies("How to");
    }

    public void setBookCopies(BookCopy bookCopy) {
        this.bookCopies.add(bookCopy);
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }
}
