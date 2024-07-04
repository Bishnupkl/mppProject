package UI;

import javax.swing.*;
import java.awt.*;

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

    }
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login mf = new Login();
            }
        });
    }
}
