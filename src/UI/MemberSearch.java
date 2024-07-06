package UI;

import Business.Book.Book;
import Business.Book.BookCopy;
import Business.Checkout.CheckoutRecord;
import Business.Person.Member;

import java.time.format.DateTimeFormatter;
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
        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(memberSearchPanel);

        searchMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIdField.getText();
                name.setText("-");
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
//                System.out.println("submit clicked");
                if (foundMember == null) {
                    JOptionPane.showMessageDialog(null, "please search member first", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                };
                CheckoutRecordTable.Show(foundMember.getCheckoutRecords());
            }
        });
    }



}
