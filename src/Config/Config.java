package Config;

import Business.Person.User;
import Business.Person.UserRole;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public final class Config {

    private static List<String> getArrayLikeList(Properties properties, String prefix) {
        List<String> list = new ArrayList<>();
        for (int i = 0;; i++) {
            String value = properties.getProperty(prefix + "[" + i + "]");
            if (value == null) {
                break;
            }
            list.add(value);
        }
        return list;
    }

    public static List<String> getCommaSeparatedList(Properties properties, String key) {
        String value = properties.getProperty(key);
        return Arrays.asList(value.split(","));
    }

    private static Properties loadProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        }
        return properties;
    }

    public static class CredentialConfig{
        public static List<User.UserInfoWrapper> defaultUsers = new ArrayList<>();
        public static void Load() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            Properties properties = loadProperties("credential.properties");
            List<String> users = getArrayLikeList(properties, "user");

            for(String raw : users)
            {
                 List<String> user = Arrays.asList(raw.split(" "));
                 List<String> rawRoles = Arrays.asList(user.get(2));
                 List<UserRole> roles = new ArrayList<>();
                 for(String rs : rawRoles)
                 {
                     for(String r : Arrays.asList(rs.split(",")))
                     {
                         roles.add((UserRole) Class.forName(r).getConstructor().newInstance());
                     }
                 }
                defaultUsers.add(new User.UserInfoWrapper(user.get(0), user.get(1), roles));
            }
        }
    }
}
