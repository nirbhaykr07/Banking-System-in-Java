package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.*;

public class EditCustomer extends JFrame implements ActionListener {

    private JLabel lblId, lblCustomer;
    private JTextField txtCustomer;
    private JButton btnOk, btnCancel;
    private JPanel jpnl;

    public EditCustomer() {

        Container cnt = this.getContentPane();
        jpnl = new JPanel();

        Font fnt = new Font("Times New Roman", Font.BOLD, 25);

        lblCustomer = new JLabel("EDIT CUSTOMER DETAILS");
        lblId = new JLabel("Enter the Customer Id");
        txtCustomer = new JTextField();
        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");

        lblCustomer.setFont(fnt);

        jpnl.add(lblCustomer);
        jpnl.add(lblId);
        jpnl.add(txtCustomer);
        jpnl.add(btnOk);
        jpnl.add(btnCancel);

        lblCustomer.setForeground(Color.red);

        lblId.setForeground(Color.black);
        txtCustomer.setForeground(Color.black);
        btnOk.setForeground(Color.black);
        btnCancel.setForeground(Color.black);

        lblCustomer.setBounds(300, 100, 450, 100);
        lblId.setBounds(300, 250, 150, 25);
        txtCustomer.setBounds(450, 250, 150, 25);
        btnOk.setBounds(325, 320, 100, 25);
        btnCancel.setBounds(455, 320, 100, 25);

        btnOk.addActionListener(this);
        btnCancel.addActionListener(this);
        jpnl.setLayout(null);

        cnt.add(jpnl);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnOk) {
            String Id;
            if (txtCustomer.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer Id Not Provided.");
                txtCustomer.requestFocus();
            } else {

                try {
                    Statement stmt = DBConnection.getConnection().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE userid='" + txtCustomer.getText() + "'");
                    rs.next();
                    Id = rs.getString(1);
                    rs.close();
                    stmt.close();
                    if (txtCustomer.getText().equals(Id)) {
                        JOptionPane.showMessageDialog(this, "Record Found");
                        ChangeCustomer chngeCust = new ChangeCustomer(txtCustomer.getText());
                        chngeCust.setVisible(true);
                        chngeCust.setSize(1368, 740);
                        setVisible(false);
                        dispose();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "No Record Found");
                    txtCustomer.requestFocus();
                }
            }
        }

        if (obj == btnCancel) {
            BankingMenu bmnu = new BankingMenu();
            bmnu.setVisible(true);
            bmnu.setSize(1368, 740);
            setVisible(false);
            dispose();
        }
    }
}
