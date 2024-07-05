package Business.Person;
import DataAccess.UserDataAccess;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class User extends Person{
    private List<UserRole> userRoles;
    private String id;

    public String getId() {
        return id;
    }

    private String password;

    User(String id, String password, List<UserRole> userRoles)
    {
        super("","", "", null);
        this.id  = id;
        this.password = password;
        this.userRoles = userRoles;
    }

//    public static void addDefaultUser(List<User> users)
//    {
//        UserDataAccess.addUsers(users);
//    }

    public static void addDefaultUsers(List<UserInfoWrapper> defaultUsers)
    {
        List<User> users = new ArrayList<>();
        for(UserInfoWrapper info: defaultUsers)
        {
            users.add(PersonFactory.generateUser(info.id, info.password, info.userRoles));
        }
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

    public static class UserInfoWrapper{
        private String id;
        private String password;
        private List<UserRole> userRoles;
        public UserInfoWrapper(String id, String password, List<UserRole> userRoles)
        {
            this.id  = id;
            this.password = password;
            this.userRoles = userRoles;
        }
    }
}
