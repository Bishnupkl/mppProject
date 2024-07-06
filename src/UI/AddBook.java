package UI;

import Business.Book.Book;
import Business.Person.Author;
import Business.Person.PersonFactory;
import Helper.StatusInfoWrapper;

import javax.swing.*;
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

    public AddBook() {
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Book");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(AddBookPane);

        list1.setSelectedIndex(0);

        buttonGroup.add(a21DaysRadioButton);
        buttonGroup.add(a7DaysRadioButton);
        a21DaysRadioButton.setSelected(true);
        borrowDuraration = 21;

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
                int copies = Integer.valueOf(noOfCopies.getText());
                List<String> authors = list1.getSelectedValuesList();


                List<Author> authorsObject = new ArrayList<>();
                for (String author : authors) {
                    authorsObject.add(PersonFactory.generateAuthor(author, "", "011222333", "Master", "Good Author", "4th North", "Fairfield", "IOWA", "52557"));
                }
                StatusInfoWrapper result = Book.addBook(isbnValue, name, borrowDuraration, authorsObject, copies);
                JOptionPane.showMessageDialog(null, result.getMessage(), "Book Creation", result.getStatus() ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
                isbn.setText("");
                bookName.setText("");
                list1.clearSelection();

            }
        });
    }


}
