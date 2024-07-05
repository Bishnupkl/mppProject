package UI;

import Business.Book.Book;
import Business.Person.Address;
import Business.Person.Author;
import Business.StatusInfoWrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddBook extends JFrame {
    private JPanel AddBookPane;
    private JTextField isbn;
    private JButton addButton;
    private JTextField bookName;
    private JList list1;
    private JRadioButton a21DaysRadioButton;
    private JRadioButton a7DaysRadioButton;
    private JTextField noOfCopies;
    ButtonGroup buttonGroup = new ButtonGroup();


    private int borrowDuraration;

    public AddBook(){
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Book");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(AddBookPane);

        list1.setSelectedIndex(0);

        buttonGroup.add(a21DaysRadioButton);
        buttonGroup.add(a7DaysRadioButton);

        a21DaysRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                borrowDuraration = 21;
            }
        });
        a7DaysRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                borrowDuraration = 7;

            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String isbnValue = isbn.getText();
                String name = bookName.getText();
                List<String> authors = list1.getSelectedValuesList();


                Address address = new Address("4th", "Fairfield", "IOWA", "52772");
                List<Author> authorsObject = new ArrayList<>();
                for (String a : authors) {
                    authorsObject.add(new Author(a, "John", "011222333", address, "Master", "Good Author"));
                }

                if (authorsObject.size() == 0) {
                    authorsObject.add(new Author("Author", "John", "011222333", address, "Master", "Good Author"));

                }


                System.out.println(authorsObject);

                StatusInfoWrapper result = Book.addBook(isbnValue, name, borrowDuraration, authorsObject);
                JOptionPane.showMessageDialog(null, result.getMessage(), "Book Creation", result.getStatus() ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
                isbn.setText("");
                bookName.setText("");
                list1.clearSelection();

            }
        });
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
