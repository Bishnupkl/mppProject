package UI;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Checkout.CheckoutRecord;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckoutRecordTable {
    public static void Show(List<CheckoutRecord> checkoutRecords) {
        JFrame f;
        JTable j;
        CheckoutRecord checkoutRecord;
        Book book;
        BookCopy bookCopy;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YY");
        String returnDate;

        f = new JFrame();
        f.setTitle("Checkout record");
        String[] columnNames = { "ISBN", "book title", "copy number", "checkout date", "due date", "return date" };
        String[][] data = new String[checkoutRecords.size()][];

        for (int i =0, n = checkoutRecords.size(); i < n; i++) {
            checkoutRecord  = checkoutRecords.get(i);
            bookCopy = checkoutRecord.getBookCopy();
            book = bookCopy.getBook();
            returnDate = "-";
            if (checkoutRecord.getReturnDate() != null) {
                returnDate = formatter.format(checkoutRecord.getReturnDate());
            }
            data[i] = new String[]{
                    book.getIsbn(),
                    book.getTitle(),
                    bookCopy.getId(),
                    formatter.format(checkoutRecord.getCheckoutDate()),
                    formatter.format(checkoutRecord.getDueDate()),
                    returnDate,
            };
        }
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
//        memberSearchPanel.add(sp);
        f.add(sp);
        f.setSize(500, 200);
        f.setVisible(true);
    }
}
