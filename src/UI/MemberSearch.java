package UI;

import javax.swing.*;
import java.awt.*;

public class MemberSearch extends JFrame {

    private JPanel memberSearchPanel;
    private JTextField textField1;
    private JButton searchMember;
    private JLabel name;
    private JButton pintButton;


    public MemberSearch() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Form");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(memberSearchPanel);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MemberSearch mf = new MemberSearch();
            }
        });
    }
}
