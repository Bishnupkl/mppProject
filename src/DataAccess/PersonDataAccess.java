package DataAccess;


import Business.Person.Person;
import Business.Person.User;

public class PersonDataAccess extends FileDataAccess{
    private static final String fileName = "person.bin";
    //private static final PersonDataAccess instance = new PersonDataAccess();

    private PersonDataAccess(){};

    public static Person readPerson(String id)
    {
        return new Person();
    }

    public void readPersons()
    {

    }
}