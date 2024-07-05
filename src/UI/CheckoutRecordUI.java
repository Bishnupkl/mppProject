package UI;

import javax.swing.*;

public class CheckoutRecordUI extends  JFrame{
    private JPanel checkOutRecordUIPanel;
    private JButton listBookCopyButton;


    public CheckoutRecordUI() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Form");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(checkOutRecordUIPanel);
    }
}
