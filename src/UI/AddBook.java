package UI;

import Business.Book.Book;
import Business.Person.Address;
import Business.Person.Author;

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
    private int borrowDuraration;

    public AddBook() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Book");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(AddBookPane);


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



                Address address = new Address("4th","Fairfield","IOWA",52772);
                List<Author> authorsObject=new ArrayList<>();
                for (String a:authors){
                    authorsObject.add(new Author(a,"John","011222333",address,"Master","Good Author"));
                }
                Book newBook= new Book(isbnValue,name,borrowDuraration,authorsObject);
                boolean result = Book.addBook(newBook);

                if(result){
                    JOptionPane.showMessageDialog(null, "Book created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    isbn.setText("");
                    bookName.setText("");
                    list1.clearSelection();


                }else{
                    JOptionPane.showMessageDialog(null, "Can't create book", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
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
