package UI;

import javax.swing.*;

public class Checkout  extends  JFrame{
    private JPanel checkOutPanel;
    private JTextField memberId;
    private JTextField isbn;
    private JButton checkoutButton;

    public Checkout() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("New Member Form");
        setSize(480, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(checkOutPanel);
    }
}
