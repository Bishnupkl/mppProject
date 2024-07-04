package Business.Book;

import Business.Person.Author;

import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private List<BookCopy> bookCopies;
    private List<Author> authors;

    public Book(String newIsbn, String newTitle, List<BookCopy> newBookCopies, List<Author> newAuthors) {
        this.isbn = newIsbn;
        this.title = newTitle;
        this.bookCopies = newBookCopies;
        this.authors = newAuthors;
    }

}
