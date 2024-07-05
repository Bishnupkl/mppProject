package UI;

import Business.Person.Member;
import Business.StatusInfoWrapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkout  extends  JFrame{
    private JPanel checkOutPanel;
    private JTextField memberId;
    private JTextField isbn;
    private JButton checkoutButton;

    public Checkout() {
        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("New Member Form");
        setSize(480, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(checkOutPanel);
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String isbnValue = isbn.getText();
                String memberIDValue = memberId.getText();

                StatusInfoWrapper result = Member.checkout(memberIDValue, isbnValue);
                if(result.getStatus())
                {
                    Member m = (Member) result.getValue();
                    CheckoutRecordTable.Show(m.getCheckoutRecords());
                }else{
                    JOptionPane.showMessageDialog(null, result.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);


                }



            }
        });
    }
}
