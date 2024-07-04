package DataAccess;


import Business.Person.Person;
import Business.Person.User;


import java.util.List;

public class PersonDataAccess extends FileDataAccess{
    private static final String fileName = "person.bin";
    private static final PersonDataAccess instance = new PersonDataAccess();


    private PersonDataAccess(){};

    public static Person readPerson(String id)
    {
        return instance.readPerson();
    }

    private Person readPerson()
    {
        User u =  (User)super.read(fileName);
        return u;
    }

    public List<Person> readPersons()
    {
        List<Person> persons = (List<Person>)super.read(fileName);
        return persons;
    }

    public static void addPerson(Person person)
    {
        instance._addPerson(person);
    }
    private void _addPerson(Person person)
    {
        List<Person> persons = readPersons();
        persons.add(person);
        super.write(fileName, persons);
    }
}
