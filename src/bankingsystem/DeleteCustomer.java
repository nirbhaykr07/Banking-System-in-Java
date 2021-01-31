package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Calendar;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;

public class DeleteCustomer extends JFrame implements ActionListener {

    private JLabel lblUserId, lblDeleteBoook;
    private JTextField txtUserId;
    private JButton btnOk, btnCancel;
    private JPanel jpnl;

    public DeleteCustomer() {

        Container cnt = this.getContentPane();

        jpnl = new JPanel();

        Font fnt = new Font("Times New Roman", Font.BOLD, 25);

        lblDeleteBoook = new JLabel("DELETE CUSTOMER DETAILS");
        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");
        txtUserId = new JTextField();
        lblUserId = new JLabel("Enter the Customer Id to be Deleted");

        lblDeleteBoook.setFont(fnt);

        jpnl.add(btnOk);
        jpnl.add(btnCancel);
        jpnl.add(txtUserId);
        jpnl.add(lblUserId);
        jpnl.add(lblDeleteBoook);

        btnOk.setForeground(Color.black);
        btnCancel.setForeground(Color.black);
        txtUserId.setForeground(Color.black);
        lblUserId.setForeground(Color.black);

        lblDeleteBoook.setForeground(Color.red);

        lblUserId.setBounds(320, 250, 300, 50);
        txtUserId.setBounds(350, 320, 150, 25);
        btnOk.setBounds(310, 370, 100, 25);
        btnCancel.setBounds(440, 370, 100, 25);

        lblDeleteBoook.setBounds(270, 100, 400, 100);

        btnOk.addActionListener(this);
        btnCancel.addActionListener(this);
        jpnl.setLayout(null);

        cnt.add(jpnl);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnOk) {
            String userId;
            if (txtUserId.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer Id not Provided.");
                txtUserId.requestFocus();
            } else {

                try {
                    userId = txtUserId.getText();
                    Statement stmt = DBConnection.getConnection().createStatement();
                    int n = stmt.executeUpdate("DELETE from account WHERE userid='" + txtUserId.getText() + "'");
                    stmt.close();
                    if (n == 0) {
                        txtUserId.requestFocus();
                        throw new Exception();
                    } else {
                        JOptionPane.showMessageDialog(this, "Record Deleted");
                    }
                    BankingMenu mnu = new BankingMenu();
                    mnu.setVisible(true);
                    mnu.setSize(1368, 740);
                    setVisible(false);
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "No Record Found");
                    txtUserId.requestFocus();
                }
            }
        }

        if (obj == btnCancel) {
            BankingMenu mnu = new BankingMenu();
            mnu.setVisible(true);
            mnu.setSize(1368, 740);
            setVisible(false);
            dispose();
        }
    }
}
