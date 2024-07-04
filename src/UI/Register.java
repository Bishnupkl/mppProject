package UI;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {
    private JPanel RegisterPane;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField street;
    private JTextField city;
    private JTextField stateTextField;
    private JButton submitMemberButton;


    public Register() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("New Member Form");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(RegisterPane);
    }


    public static void main(String[] args) {
        /*
        While it is not mandatory to use EventQueue.invokeLater,
        it is a best practice for all Swing applications to ensure
        thread safety and avoid potential concurrency issues.
         */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Register mf = new Register();
            }
        });
    }
}
