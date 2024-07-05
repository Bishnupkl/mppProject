package UI;

import Business.Person.Administrator;
import Business.Person.Librarian;
import Business.Person.User;
import Business.Person.UserRole;

import javax.swing.*;
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
    private JButton displayBookCopyButton;


    public MainMenu(User loginUser) {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(mainMenu);
        addBookButton.setVisible(false);
        addCopyButton.setVisible(false);
        addMemberButton.setVisible(false);
        searchmember.setVisible(false);
        searchBookButton.setVisible(false);
        checkOutButton.setVisible(false);
        addMemberButton.setVisible(false);
        displayBookCopyButton.setVisible(false);


        for (UserRole role : loginUser.getRole()) {
            if (role instanceof Administrator) {
                System.out.println("Administrator");
                addBookButton.setVisible(true);
                addCopyButton.setVisible(true);
                addMemberButton.setVisible(true);
            }

            if (role instanceof Librarian) {
                System.out.println("Librarian");

                searchmember.setVisible(true);
                checkOutButton.setVisible(true);
                displayBookCopyButton.setVisible(true);
                searchBookButton.setVisible(true);
            }
        }


        searchmember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MemberSearch ms = new MemberSearch();
            }
        });
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Register ms = new Register();

            }
        });
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                AddBook addBook=new AddBook()
            }
        });
        addCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCopy addBook = new AddCopy();
            }
        });
    }

//    public static void main(String[] args) {
//
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                MainMenu mf = new MainMenu();
//            }
//        });
//    }
}
