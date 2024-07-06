package UI;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Checkout.CheckoutRecord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SearchBook extends JFrame {
    private JPanel searchBook;
    private JTextField isnValue;
    private JButton searchButton;

    public SearchBook() {
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(searchBook);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String isbn = isnValue.getText();

                List<BookCopy> bookCopies = Book.getBookCopies(isbn);
                if (bookCopies != null) {

                    showBookCopies(bookCopies);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid ISBN", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }

            public static void showBookCopies(List<BookCopy> bookCopies) {
                JFrame f;
                JTable j;
                CheckoutRecord checkoutRecord;
                Book book;
                BookCopy bookCopy;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YY");
                String returnDate;

                f = new JFrame();
                f.setTitle("Book Information");
                String[] columnNames = {"ISBN", "Book title", "Copy ID", "Member ID", "Member Name", "Checkout date", "Due date", "Return date"};
                String[][] data = new String[bookCopies.size()][];

                for (int i = 0, n = bookCopies.size(); i < n; i++) {
//                    checkoutRecord  = bookCopies.get(i);
                    bookCopy = bookCopies.get(i);
                    book = bookCopy.getBook();
                    returnDate = "-";
//                    if (checkoutRecord.getReturnDate() != null) {
//                        returnDate = formatter.format(checkoutRecord.getReturnDate());
//                    }
                    data[i] = new String[]{
                            book.getIsbn(),
                            book.getTitle(),
                            bookCopy.getId(),
                            (bookCopy.getCheckoutRecord() != null) ? bookCopy.getCheckoutRecord().getMember().getId() : null,
                            (bookCopy.getCheckoutRecord() != null) ? bookCopy.getCheckoutRecord().getMember().getFirstName() + " " + bookCopy.getCheckoutRecord().getMember().getLastName() : null,
                            (bookCopy.getCheckoutRecord() != null) ? formatter.format(bookCopy.getCheckoutRecord().getCheckoutDate()) : null,
                            (bookCopy.getCheckoutRecord() != null) ? formatter.format(bookCopy.getCheckoutRecord().getDueDate()) : null,
                            returnDate,
                    };
                }
                j = new JTable(data, columnNames);
                j.setBounds(30, 40, 200, 300);
                JScrollPane sp = new JScrollPane(j);
//        memberSearchPanel.add(sp);
                f.add(sp);
                f.setSize(800, 400);
                f.setVisible(true);
            }

        });
    }

}
