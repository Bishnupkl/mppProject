package Business.Person;

import Business.Book.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author extends Person implements Serializable  {

    private List<Book> books = new ArrayList<>();
    private String credentials;
    private String bio;

    public Author(String firstName,String lastName, String phoneNumber,Address address,  String credentials, String bio) {
        super(firstName,lastName,phoneNumber,address);
        this.credentials = credentials;
        this.bio = bio;
    }

    public void setBook(Book newBook){
        books.add(newBook);
    }
}
