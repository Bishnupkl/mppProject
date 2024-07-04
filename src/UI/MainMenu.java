package UI;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JPanel mainMenu;
    private JButton addBookButton;
    private JButton addCopyButton;
    private JButton addMemberButton;
    private JButton checkOutButton;
    private JButton searchBookButton;


    public MainMenu() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(mainMenu);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainMenu mf = new MainMenu();
            }
        });
    }
}
