package UI;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.StatusInfoWrapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCopy extends JFrame {
    private JTextField isbn;
    private JButton addCopyButton;
    private JPanel addCopyPanel;


    public AddCopy() {
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Book");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(addCopyPanel);
        addCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String isbnValue = isbn.getText();
                StatusInfoWrapper result = Book.addCopy(isbnValue);
                JOptionPane.showMessageDialog(null, result.getMessage(), "Book Creation", result.getStatus() ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
