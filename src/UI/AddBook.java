package UI;

import javax.swing.*;
import java.awt.*;

public class AddBook extends JFrame {
    private JPanel AddBookPane;
    private JTextField isbn;
    private JButton addButton;
    private JTextField bookName;
    private JList list1;
    private JRadioButton a21DaysRadioButton;
    private JRadioButton a7DaysRadioButton;

    public AddBook() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Book");
        setSize(500, 400);
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

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(new JRadioButton("21 Days", false));
        buttonGroup.add(new JRadioButton("7 Days", true));

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddBook mf = new AddBook();
            }
        });
    }


}
