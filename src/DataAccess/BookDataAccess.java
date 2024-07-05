package DataAccess;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Checkout.CheckoutRecord;
import Business.Person.Member;

import java.util.ArrayList;
import java.util.List;

public  class BookDataAccess extends FileDataAccess {
    private static final String fileName = "book.bin";
    private static final BookDataAccess instance = new BookDataAccess();
    private BookDataAccess(){}
    public static Book readBook(String isbn)
    {
        List<Book> books= instance.readBooks();
        if(books==null){
            return null;
        }
        for (Book book:  instance.readBooks()) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    public List<Book> readBooks()
    {
        List<Book> books=(List<Book>)super.read(fileName);
        if(books==null){
            return new ArrayList<>();
        }
        return books;
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



    public static void addCheckoutRecord(CheckoutRecord checkoutRecord)
    {
        instance._addCheckoutRecord(checkoutRecord);
    }

    private void _addCheckoutRecord(CheckoutRecord checkoutRecord)
    {

        List<Book> books = readBooks();
        for(Book book : books)
        {
            if(book.getIsbn().equals(checkoutRecord.getBookCopy().getBook().getIsbn()))
            {
                for(BookCopy bc : book.getBookCopies())
                {
                    if(bc.getId().equals(checkoutRecord.getBookCopy().getId()))
                    {
                        bc.setCheckoutRecord(checkoutRecord);
                        break;
                    }
                }
                break;
            }
        }
        super.write(fileName, books);
    }

}
