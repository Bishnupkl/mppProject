import Business.Person.User;
import Config.Config;
import UI.Login;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Config.CredentialConfig.Load();
        User.addDefaultUsers(Config.CredentialConfig.defaultUsers);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login mf = new Login();
            }
        });
    }
}
