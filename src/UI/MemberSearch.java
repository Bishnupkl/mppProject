package UI;

import Business.Person.Member;

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
                JTable table = new JTable(new String[][]{
                        {"hello", "there"},
                        {"hi", "here"},
                }, new String[]{"a", "b"});
                self.add(table);
            }
        });
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MemberSearch mf = new MemberSearch();
            }
        });
    }
}
