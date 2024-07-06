package Business.Person;

import java.io.Serializable;

public class Address implements Serializable {
    private String street;
    private String city;
    private String state;
    private String zip;

     Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }
}
