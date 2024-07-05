package DataAccess;

import Business.Person.User;

import java.util.List;

public class UserDataAccess extends FileDataAccess{
    private static final String fileName = "user.bin";
    private static final UserDataAccess instance = new UserDataAccess();
    private UserDataAccess(){};

    public static User readUser(String id)
    {
        List<User> users = instance.readUsers();
        for(User u : users)
        {
            if(u.getId().equals(id)) return u;
        }
        return null;
    }

    public List<User> readUsers()
    {
        List<User> users = (List<User>)super.read(fileName);
        return users;
    }
    public static void addUsers(List<User> users)
    {
        instance._addUsers(users);
    }
    private void _addUsers(List<User> users)
    {
        super.write(fileName, users);
    }
}
