package Business.Person;

import DataAccess.PersonDataAccess;
import DataAccess.UserDataAccess;

import java.util.HashSet;
import java.util.List;

public class User extends Person{
    private List<UserRole> userRoles;
    private String id;

    public String getId() {
        return id;
    }

    private String password;

    public User(String id, String password, List<UserRole> userRoles)
    {
        super("","");
        this.id  = id;
        this.password = password;
        this.userRoles = userRoles;
    }

    public void addDefaultUser(List<User> users)
    {
        UserDataAccess.addUsers(users);
    }

    public static User login(String id, String password)
    {
        User user = (User)UserDataAccess.readUser(id);
        if(user == null || verifyCredential(password,user) == false)
        {
            return null;
        }
        return user;
    }

    public List<UserRole> getRole() {
        return this.userRoles;
    }

    private static boolean verifyCredential(String password, User user)
    {
        return user.password.equals(password);
    }
}
