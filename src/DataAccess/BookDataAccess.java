package DataAccess;

import Business.Book.Book;

public class BookDataAccess extends FileDataAccess{

    public void readBook()
    {
        Book book =  (Book)super.read("book.bin");
    }
}
