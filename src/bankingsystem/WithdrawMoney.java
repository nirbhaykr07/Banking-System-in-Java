package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;

public class WithdrawMoney extends JFrame implements ActionListener {

    private JLabel lblId, lblAmount, lblWithdrawMoney;
    private JTextField txtId, txtAmount;
    private JButton btnOk, btnCancel;
    private JPanel jpnl;

    public WithdrawMoney() {

        Container cnt = this.getContentPane();

        Font fnt = new Font("Times New Roman", Font.BOLD, 25);
        jpnl = new JPanel();

        lblWithdrawMoney = new JLabel("WITHDRAW MONEY");
        lblId = new JLabel("Customer Id");
        lblAmount = new JLabel("Withdrawl Amount");

        txtId = new JTextField();
        txtAmount = new JTextField();

        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");

        lblWithdrawMoney.setFont(fnt);

        jpnl.add(lblWithdrawMoney);
        jpnl.add(lblId);
        jpnl.add(lblAmount);
        jpnl.add(txtId);
        jpnl.add(txtAmount);
        jpnl.add(btnOk);
        jpnl.add(btnCancel);

        lblWithdrawMoney.setForeground(Color.red);

        lblId.setForeground(Color.black);
        lblAmount.setForeground(Color.black);
        txtId.setForeground(Color.black);
        txtAmount.setForeground(Color.black);
        btnOk.setForeground(Color.black);
        btnCancel.setForeground(Color.black);

        lblWithdrawMoney.setBounds(320, 100, 300, 50);
        lblId.setBounds(300, 250, 150, 25);
        lblAmount.setBounds(300, 300, 150, 25);

        txtId.setBounds(450, 250, 150, 25);
        txtAmount.setBounds(450, 300, 150, 25);

        btnOk.setBounds(300, 430, 100, 25);
        btnCancel.setBounds(430, 430, 100, 25);

        btnOk.addActionListener(this);
        btnCancel.addActionListener(this);

        jpnl.setLayout(null);

        cnt.add(jpnl);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnOk) {

            String strId = txtId.getText();
            String strAmount = txtAmount.getText();
            if (txtId.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer Id field can't be left blank");
                txtId.requestFocus();
            } else if (txtAmount.getText().equals("")) {
                txtAmount.requestFocus();
                JOptionPane.showMessageDialog(null, "Amount field can't be left blank");
            } else {
                try {
                    Statement stmt = DBConnection.getConnection().createStatement();
                    ResultSet rsId = stmt.executeQuery("SELECT * FROM account WHERE userid='" + strId + "'");
                    if (rsId.next() == true) {
                        String bal = rsId.getString(8);
                        if (Float.parseFloat(bal) < Float.parseFloat(strAmount)) {
                            JOptionPane.showMessageDialog(this, "Balance is less than entered withdrawl amount");
                        } else {
                            stmt.executeUpdate("Update account SET balance = balance -" + strAmount + " WHERE userid='" + strId + "'");
                            JOptionPane.showMessageDialog(this, "Withdrawl successful");
                            rsId.close();
                            stmt.close();
                            BankingMenu bmnu = new BankingMenu();
                            bmnu.setSize(1368, 740);
                            bmnu.setVisible(true);
                            setVisible(false);
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Customer Id does not exist");
                    }
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Wrong data entered ");
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
