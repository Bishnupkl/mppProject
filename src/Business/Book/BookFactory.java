package Business.Book;

import Business.Person.Author;

import java.util.List;

public final class BookFactory {
    private BookFactory(){}
    public static Book generateBook(String newIsbn, String newTitle, int newBorrowDuration, List<Author> newAuthors ,int copies){

        Book newBook = new Book(newIsbn, newTitle, newBorrowDuration, newAuthors);
        int tmp=0;
        while (tmp<copies){
            newBook.setBookCopies(generateBookCopy(newBook));
            tmp++;
        }
        return newBook;
    }
    public static BookCopy generateBookCopy(Book book){
        return new BookCopy(book);
    }
}
