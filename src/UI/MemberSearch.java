package UI;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Checkout.CheckoutRecord;
import Business.Person.Member;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberSearch extends JFrame {

    private JPanel memberSearchPanel;
    private JTextField memberIdField;
    private JButton searchMember;
    private JLabel name;
    private JButton printCheckoutRecordButton;
    private Member foundMember;


    public MemberSearch() {
        JFrame self = this;
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("search member");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(memberSearchPanel);

        searchMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIdField.getText();
                foundMember = Member.getMember(memberId);
                if (foundMember == null) {
                    JOptionPane.showMessageDialog(null, String.format("Not found user with id: %s", memberId), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                System.out.println(foundMember);
                name.setText(String.format("%s %s", foundMember.getFirstName(), foundMember.getLastName()));
            }
        });

        printCheckoutRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("submit clicked");
                showTable();
            }
        });
    }

    private void showTable() {
        JFrame f;
        JTable j;
        List<CheckoutRecord> checkoutRecords;
        Book book;
        BookCopy bookCopy;

        if (foundMember == null) return;
        checkoutRecords = foundMember.getCheckoutRecords();
        f = new JFrame();
        f.setTitle("Checkout record");
        String[] columnNames = { "ISBN", "book title", "copy number" };
        String[][] data = new String[checkoutRecords.size()][];

        for (int i =0, n = checkoutRecords.size(); i < n; i++) {
            bookCopy = checkoutRecords.get(i).getBookCopy();
            book = bookCopy.getBook();
            data[i] = new String[]{
                    book.getIsbn(),
                    book.getTitle(),
                    bookCopy.getId(),
            };
        }
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(500, 200);
        f.setVisible(true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MemberSearch mf = new MemberSearch();
            }
        });
    }
}
