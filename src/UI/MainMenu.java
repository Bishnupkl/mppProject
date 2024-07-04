package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JPanel mainMenu;
    private JButton addBookButton;
    private JButton addCopyButton;
    private JButton addMemberButton;
    private JButton checkOutButton;
    private JButton searchBookButton;
    private JButton searchmember;


    public MainMenu() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(mainMenu);

        searchmember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            MemberSearch ms= new MemberSearch();
            }
        });
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Register ms= new Register();

            }
        });
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainMenu mf = new MainMenu();
            }
        });
    }
}
