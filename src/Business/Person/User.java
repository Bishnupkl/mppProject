package Business.Person;

import DataAccess.UserDataAccess;

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

    private static boolean verifyCredential(String password, User user)
    {
        return user.password.equals(password);
    }
}
