package DataAccess;

import Business.Book.Book;

import java.util.ArrayList;
import java.util.List;

public  class BookDataAccess extends FileDataAccess {

    private static BookDataAccess bda=new BookDataAccess();

    public static List<Book> readBooks() {
       return bda._readBooks();
    }

    private List<Book> _readBooks(){
        List<Book> books = (List<Book>) super.read("book.bin");
        if(books==null){
            return new ArrayList<>();
        }
        return books;
    }


    public static void createNewBook(List<Book> books){
        bda._createNewBook(books);
    }


    public void _createNewBook(List<Book> books){
        write("book.bin",books);
    }



}
