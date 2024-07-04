package Business.Person;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;

    private String phoneNumber;
    private Address address;

    public Person(String firstName, String lastName, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Person(){

    }

}
