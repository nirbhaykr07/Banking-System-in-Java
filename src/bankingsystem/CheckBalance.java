package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.*;

public class CheckBalance extends JFrame implements ActionListener {

    private JLabel lblId, lblCheckBalance;
    private JTextField txtId;
    private JButton btnOk, btnCancel;
    private JPanel jpnl;

    public CheckBalance() {

        Container cnt = this.getContentPane();

        Font fnt = new Font("Times New Roman", Font.BOLD, 25);
        jpnl = new JPanel();

        lblCheckBalance = new JLabel("CHECK BALANCE");
        lblId = new JLabel("Customer Id");

        txtId = new JTextField();

        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");

        lblCheckBalance.setFont(fnt);

        jpnl.add(lblCheckBalance);
        jpnl.add(lblId);
        jpnl.add(txtId);
        jpnl.add(btnOk);
        jpnl.add(btnCancel);

        lblCheckBalance.setForeground(Color.red);

        lblId.setForeground(Color.black);
        txtId.setForeground(Color.black);
        btnOk.setForeground(Color.black);
        btnCancel.setForeground(Color.black);

        lblCheckBalance.setBounds(320, 100, 300, 50);
        lblId.setBounds(300, 250, 150, 25);

        txtId.setBounds(450, 250, 150, 25);

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
            if (txtId.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer Id field can't be left blank");
                txtId.requestFocus();
            } else {
                try {
                    Statement stmt = DBConnection.getConnection().createStatement();
                    ResultSet rsId = stmt.executeQuery("SELECT * FROM account WHERE userid='" + strId + "'");
                    if (rsId.next() == true) {
                        String bal = rsId.getString(8);
                        JOptionPane.showMessageDialog(this, "Balance = " + bal);
                        rsId.close();
                        stmt.close();
                        BankingMenu bmnu = new BankingMenu();
                        bmnu.setSize(1368, 740);
                        bmnu.setVisible(true);
                        setVisible(false);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Customer Id does not exist");
                    }
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Problem while fetching the Record");
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
