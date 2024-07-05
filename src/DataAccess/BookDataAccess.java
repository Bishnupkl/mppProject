package DataAccess;

import Business.Book.Book;
import java.util.List;

public  class BookDataAccess extends FileDataAccess {
    private static final String fileName = "book.bin";
    private static final BookDataAccess instance = new BookDataAccess();
    private BookDataAccess(){}
    public static Book readBook(String isbn)
    {
        for (Book book:  instance.readBooks()) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    public List<Book> readBooks()
    {
        return (List<Book>)super.read(fileName);
    }

    public static void createNewBook(Book book){
        instance._createNewBook(book);
    }


    public void _createNewBook(Book book){

        List<Book> books = readBooks();
        books.add(book);
        write(fileName,books);
    }

    public static void createNewBookCopy(Book book){
        instance._createNewBookCopy(book);
    }


    public void _createNewBookCopy(Book book){

        List<Book> books = readBooks();
        for(Book b : books)
        {
            if(b.getIsbn().equals(book.getIsbn()))
            {
                b = book;
            }
        }
        write(fileName,books);
    }

}
