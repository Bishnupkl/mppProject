package UI;

import Business.Book.Book;
import Business.Book.BookCopy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchBook extends  JFrame {
    private JPanel searchBook;
    private JTextField isnValue;
    private JButton searchButton;

    public SearchBook() {
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(searchBook);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String isbn = isnValue.getText();

                List<BookCopy> bookCopies = Book.getBookCopies(isbn);
                for (BookCopy copy : bookCopies) {
                    System.out.println(copy.getId());

                }

            }
        });
    }

}
