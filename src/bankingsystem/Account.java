package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Account extends JFrame implements ActionListener {

    private JLabel lblId, lblName, lblDob, lblSex, lblAddr, lblAccType, lblCustomer, lblContact, lblBalance;
    private JTextField txtId, txtName, txtDob, txtSex, txtAddr, txtAccType, txtContact, txtBalance;
    private JButton btnOk, btnCancel;
    private JPanel jpnl;

    public Account() {
        Container cnt = this.getContentPane();
        Font f1 = new Font("Times New Roman", Font.BOLD, 25);

        jpnl = new JPanel();

        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");

        lblCustomer = new JLabel("ADD CUSTOMER DETAILS");

        lblId = new JLabel("Customer Id");
        lblName = new JLabel("Customer Name");
        lblDob = new JLabel("Date of Birth");
        lblSex = new JLabel("Sex");
        lblAddr = new JLabel("Address");
        lblAccType = new JLabel("Account Type");
        lblContact = new JLabel("Contact No.");
        lblBalance = new JLabel("Balance");

        btnOk.setForeground(Color.black);
        btnCancel.setForeground(Color.black);

        lblCustomer.setForeground(Color.RED);

        lblId.setForeground(Color.black);
        lblName.setForeground(Color.black);
        lblDob.setForeground(Color.black);
        lblSex.setForeground(Color.black);
        lblAddr.setForeground(Color.black);
        lblAccType.setForeground(Color.black);
        lblContact.setForeground(Color.black);
        lblBalance.setForeground(Color.black);

        lblCustomer.setFont(f1);

        txtId = new JTextField();
        txtName = new JTextField();
        txtDob = new JTextField();
        txtSex = new JTextField();
        txtAddr = new JTextField();
        txtAccType = new JTextField();
        txtContact = new JTextField();
        txtBalance = new JTextField();

        lblCustomer.setForeground(Color.red);

        txtId.setForeground(Color.black);
        txtName.setForeground(Color.black);
        txtDob.setForeground(Color.black);
        txtSex.setForeground(Color.black);
        txtAddr.setForeground(Color.black);
        txtAccType.setForeground(Color.black);
        txtContact.setForeground(Color.black);
        txtBalance.setForeground(Color.black);

        txtBalance.setText("0");
        txtBalance.setEditable(false);

        jpnl.add(lblId);
        jpnl.add(lblName);
        jpnl.add(lblDob);
        jpnl.add(lblSex);
        jpnl.add(lblAddr);
        jpnl.add(lblCustomer);
        jpnl.add(lblAccType);
        jpnl.add(lblContact);
        jpnl.add(lblBalance);

        jpnl.add(txtId);
        jpnl.add(txtName);
        jpnl.add(txtDob);
        jpnl.add(txtSex);
        jpnl.add(txtAddr);
        jpnl.add(txtAccType);
        jpnl.add(txtContact);
        jpnl.add(txtBalance);

        jpnl.add(btnOk);
        jpnl.add(btnCancel);

        lblCustomer.setBounds(380, 100, 400, 100);

        lblId.setBounds(400, 250, 150, 25);
        txtId.setBounds(500, 250, 150, 25);

        lblName.setBounds(400, 300, 150, 25);
        txtName.setBounds(500, 300, 150, 25);

        lblDob.setBounds(400, 350, 150, 25);
        txtDob.setBounds(500, 350, 150, 25);

        lblSex.setBounds(400, 400, 150, 25);
        txtSex.setBounds(500, 400, 150, 25);

        lblAddr.setBounds(400, 450, 150, 25);
        txtAddr.setBounds(500, 450, 150, 25);

        lblAccType.setBounds(400, 500, 150, 25);
        txtAccType.setBounds(500, 500, 150, 25);

        lblContact.setBounds(400, 550, 150, 25);
        txtContact.setBounds(500, 550, 150, 25);

        lblBalance.setBounds(400, 600, 150, 25);
        txtBalance.setBounds(500, 600, 150, 25);

        btnOk.setBounds(400, 670, 100, 25);
        btnCancel.setBounds(550, 670, 100, 25);

        jpnl.setLayout(null);

        cnt.add(jpnl);

        btnOk.addActionListener(this);
        btnCancel.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnOk) {
            if (txtId.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Id not Provided.");
                txtId.requestFocus();
            } else if (txtName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Name not Provided.");
                txtName.requestFocus();
            } else if (txtDob.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's DOB not Provided.");
                txtDob.requestFocus();
            } else if (txtSex.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Sex not Provided.");
                txtSex.requestFocus();
            } else if (txtAddr.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Address not Provided.");
                txtAddr.requestFocus();
            } else if (txtAccType.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Account type not Provided.");
                txtAccType.requestFocus();
            } else if (txtContact.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Contact number not Provided.");
                txtContact.requestFocus();
            } else {
                try {
                    PreparedStatement stmt = DBConnection.getConnection().prepareStatement("Insert into account values('" + txtId.getText() + "','" + txtName.getText() + "','" + txtDob.getText() + "','" + txtSex.getText() + "','" + txtAddr.getText() + "','" + txtAccType.getText() + "','" + txtContact.getText() + "'," + txtBalance.getText() + ")");
                    stmt.executeUpdate();
                    stmt.close();
                    JOptionPane.showMessageDialog(this, "Database Updated");
                    BankingMenu bMenu = new BankingMenu();
                    bMenu.setVisible(true);
                    bMenu.setSize(1368, 740);
                    setVisible(false);
                    dispose();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Problem while Saving the Record");
                }
            }
        }

        if (obj == btnCancel) {
            BankingMenu mnuObj = new BankingMenu();
            mnuObj.setVisible(true);
            mnuObj.setSize(1368, 740);
            setVisible(false);
            dispose();
        }
    }
}
