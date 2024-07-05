package UI;

import Business.Person.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JPanel RegisterPane;
    private JTextField memberIdField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField streetField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;
    private JTextField phoneField;
    private JButton submitMemberButton;


    public Register() {
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("New Member Form");
        setSize(480, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(RegisterPane);

        submitMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder errMsgBuilder = new StringBuilder();
                String errMsg;
                String memberId = memberIdField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String street = streetField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                String phone = phoneField.getText();
                String zip = zipField.getText();

                if (firstName.isEmpty()) {
                    errMsgBuilder.append("first name: required\n");
                }
                if (lastName.isEmpty()) {
                    errMsgBuilder.append("last name: required\n");
                }
                if (street.isEmpty()) {
                    errMsgBuilder.append("street: required\n");
                }
                if (city.isEmpty()) {
                    errMsgBuilder.append("city: required\n");
                }
                if (state.isEmpty()) {
                    errMsgBuilder.append("state: required\n");
                }
                if (phone.isEmpty()) {
                    errMsgBuilder.append("phone: required\n");
                }
                if (zip.isEmpty()) {
                    errMsgBuilder.append("zip code: required\n");
                }
                errMsg = errMsgBuilder.toString();
                if (!errMsg.isEmpty()) {
                    System.out.println("error!!!!!");
                    JOptionPane.showMessageDialog(null, errMsg, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Member addedMember = Member.addMember(memberId, firstName, lastName, street, city, state, zip, phone);
                System.out.printf("add member success: %s", addedMember);
                JOptionPane.showMessageDialog(null, "Member added", "Success", JOptionPane.INFORMATION_MESSAGE);
                memberIdField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                streetField.setText("");
                cityField.setText("");
                stateField.setText("");
                zipField.setText("");
                phoneField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        /*
        While it is not mandatory to use EventQueue.invokeLater,
        it is a best practice for all Swing applications to ensure
        thread safety and avoid potential concurrency issues.
         */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Register mf = new Register();
            }
        });
    }
}
