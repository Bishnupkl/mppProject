package Business.Person;

import Business.Book.Book;

import java.util.List;

public class Author extends Person{
    private List<Book> books;
    public Author()
    {
        super("","");
    }
}
