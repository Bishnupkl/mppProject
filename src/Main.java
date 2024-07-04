import Business.Person.Administrator;
import Business.Person.Librarian;
import Business.Person.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        addDefaultUser();

        User u = User.login("librarian","123");
    }

    private static void addDefaultUser()
    {
        User administrator = new User("admin", "123", new ArrayList<>(Arrays.asList(new Administrator())));

        User librarian = new User("librarian","123", new ArrayList<>(Arrays.asList(new Librarian())));

//        HashSet<User> users = new HashSet<>();
//        users.add(administrator);
//        users.add(librarian);

        administrator.addDefaultUser(new ArrayList<>(Arrays.asList(administrator, librarian)));
    }
}
