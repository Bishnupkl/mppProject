package UI;

import javax.swing.*;
import java.awt.*;

public class AddBook  extends JFrame{
    private JPanel AddBookPane;
    private JTextField isbn;
    private JTextField name;
    private JTextField noOfCopies;
    private JButton addButton;

    public AddBook() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Book");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(AddBookPane);
    }

    public static void main(String[] args) {
        /*
        While it is not mandatory to use EventQueue.invokeLater,
        it is a best practice for all Swing applications to ensure
        thread safety and avoid potential concurrency issues.
         */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddBook mf = new AddBook();
            }
        });
    }


}
