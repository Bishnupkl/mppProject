package Business.Person;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private Address address;
    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
