package UI;

import Business.Book.Book;
import Business.Book.BookCopy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCopy  extends  JFrame{
    private JTextField isbn;
    private JButton addCopyButton;

    public AddCopy() {
        addCopyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String isbnValue = isbn.getText();
                if (!Book.checkBookExist(isbnValue)) {

//                    BookCopy newCopy = new BookCopy();
                }
            }
        });
    }
}
