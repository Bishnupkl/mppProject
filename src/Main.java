import Business.Person.Administrator;
import Business.Person.Librarian;
import Business.Person.Member;
import Business.Person.User;
import UI.Login;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        addDefaultUser();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login mf = new Login();
            }
        });
//        Member m = Member.addMember("","","","","",123, "");
//        User uu =  User.login("both","123");

    }

    private static void addDefaultUser()
    {
        List<User.UserInfoWrapper> defaultUsers = new ArrayList<>();
        defaultUsers.add(new User.UserInfoWrapper("admin","123",new ArrayList<>(Arrays.asList(new Administrator()))));
        defaultUsers.add(new User.UserInfoWrapper("librarian","123",new ArrayList<>(Arrays.asList(new Librarian()))));
        defaultUsers.add(new User.UserInfoWrapper("both","123",new ArrayList<>(Arrays.asList(new Administrator(), new Librarian()))));
        User.addDefaultUsers(defaultUsers);
    }
}
