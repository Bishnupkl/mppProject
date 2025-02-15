package UI;

import Business.Person.User;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login extends JFrame {
    private JTextField userId;
    private JButton submit;
    private JPasswordField password;
    private JPanel mypanel;

    public Login() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Form");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(mypanel);


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println();
                char[] pwd = password.getPassword();
                String password = new String(pwd);
                String username = userId.getText();
                // Perform validation
                if (username.isEmpty() || password.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    User loginUser = User.login(username, password);
//               JOptionPane.showMessageDialog(null, loginUser, "Success", JOptionPane.INFORMATION_MESSAGE);
                    if (loginUser != null) {
                        MainMenu menu = new MainMenu(loginUser);
                        setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }

//                else if (username.equals("admin") && Arrays.equals(pwd, "admin123".toCharArray())) {
//                    MainMenu menu = new MainMenu();
//                    //                    JOptionPane.showMessageDialog(null, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                } else {
////                    JOptionPane.showMessmainFrameageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
//                }
            }
        });

    }

    public static void main(String[] args) {



        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login mf = new Login();
            }
        });
    }
}
