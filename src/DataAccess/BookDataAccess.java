package DataAccess;

import Business.Book.Book;

import java.util.ArrayList;
import java.util.List;

public  class BookDataAccess extends FileDataAccess {

    public List<Book> readBooks() {
        List<Book> books = (List<Book>) super.read("book.bin");
        if(books==null){
            return new ArrayList<>();
        }
        return books;
    }

    public void createNewBook(List<Book> books){


    }


}
