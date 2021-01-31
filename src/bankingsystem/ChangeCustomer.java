package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.*;

public class ChangeCustomer extends JFrame implements ActionListener {

    private JLabel lblId, lblName, lblDob, lblSex, lblAddr, lblAccType, lblContact, lblEditCust;
    private JTextField txtId, txtName, txtDob, txtSex, txtAddr, txtAccType, txtContact;
    private JButton btnOk, btnCancel;
    private JPanel jpnl;
    private String Id = "";

    public ChangeCustomer(String IdCust) {
        this.setTitle("Change Customer Details");
        Container cnt = this.getContentPane();

        jpnl = new JPanel();
        Font fnt = new Font("Times New Roman", Font.BOLD, 25);

        lblEditCust = new JLabel("CHANGE CUSTOMER DETAILS");

        lblId = new JLabel("Customer Id");
        lblName = new JLabel("Customer Name");
        lblDob = new JLabel("Date of Birth");
        lblSex = new JLabel("Sex");
        lblAddr = new JLabel("Address");
        lblAccType = new JLabel("Account type");
        lblContact = new JLabel("Contact No.");

        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");

        txtId = new JTextField();
        txtName = new JTextField();
        txtDob = new JTextField();
        txtSex = new JTextField();
        txtAddr = new JTextField();
        txtAccType = new JTextField();
        txtContact = new JTextField();

        lblEditCust.setFont(fnt);

        jpnl.add(lblId);
        jpnl.add(lblName);
        jpnl.add(lblDob);
        jpnl.add(lblSex);
        jpnl.add(lblAddr);
        jpnl.add(lblAccType);
        jpnl.add(lblContact);

        jpnl.add(txtId);
        jpnl.add(txtName);
        jpnl.add(lblEditCust);
        jpnl.add(txtDob);
        jpnl.add(txtSex);
        jpnl.add(txtAddr);
        jpnl.add(txtAccType);
        jpnl.add(txtContact);

        jpnl.add(btnOk);
        jpnl.add(btnCancel);

        jpnl.add(lblEditCust);

        lblEditCust.setForeground(Color.red);
        lblId.setForeground(Color.black);
        lblName.setForeground(Color.black);
        lblDob.setForeground(Color.black);
        lblSex.setForeground(Color.black);
        lblAddr.setForeground(Color.black);
        lblAccType.setForeground(Color.black);
        lblContact.setForeground(Color.black);

        txtId.setForeground(Color.black);
        txtName.setForeground(Color.black);
        txtDob.setForeground(Color.black);
        txtSex.setForeground(Color.black);
        lblEditCust.setForeground(Color.red);
        txtAddr.setForeground(Color.black);
        txtAccType.setForeground(Color.black);
        txtContact.setForeground(Color.black);

        btnOk.setForeground(Color.black);
        btnCancel.setForeground(Color.black);

        lblEditCust.setBounds(280, 100, 400, 100);

        lblId.setBounds(300, 200, 150, 25);
        lblName.setBounds(300, 250, 150, 25);
        lblDob.setBounds(300, 300, 150, 25);
        lblSex.setBounds(300, 350, 150, 25);
        lblAddr.setBounds(300, 400, 150, 25);
        lblAccType.setBounds(300, 450, 150, 25);
        lblContact.setBounds(300, 500, 150, 25);

        txtId.setBounds(400, 200, 150, 25);
        txtName.setBounds(400, 250, 150, 25);
        txtDob.setBounds(400, 300, 150, 25);
        txtSex.setBounds(400, 350, 150, 25);
        txtAddr.setBounds(400, 400, 150, 25);
        txtAccType.setBounds(400, 450, 150, 25);
        txtContact.setBounds(400, 500, 150, 25);

        btnOk.setBounds(300, 600, 100, 25);
        btnCancel.setBounds(450, 600, 100, 25);
        Id = IdCust;
        try {
            Statement stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE userid='" + IdCust + "'");
            rs.next();
            txtId.setText(rs.getString(1));
            txtName.setText(rs.getString(2));
            txtDob.setText(rs.getString(3));
            txtSex.setText(rs.getString(4));
            txtAddr.setText(rs.getString(5));
            txtAccType.setText(rs.getString(6));
            txtContact.setText(rs.getString(7));
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problem while fetching the Record");
        }
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
                JOptionPane.showMessageDialog(this, "Customer Id not Provided.");
                txtId.requestFocus();
            } else if (txtName.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Name not Provided.");
                txtName.requestFocus();
            } else if (txtDob.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's DOB Number not Provided.");
                txtDob.requestFocus();
            } else if (txtSex.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Sex not Provided.");
                txtSex.requestFocus();
            } else if (txtAddr.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's address not Provided.");
                txtAddr.requestFocus();
            } else if (txtAccType.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Custome's Account type not Provided.");
                txtAccType.requestFocus();
            } else if (txtContact.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Customer's Contact no. not Provided.");
                txtAccType.requestFocus();
            } else {
                try {
                    Statement stmt = DBConnection.getConnection().createStatement();
                    stmt.executeUpdate("update account set userid='" + txtId.getText() + "', username='" + txtName.getText() + "',dob='" + txtDob.getText() + "',sex='" + txtSex.getText() + "',address='" + txtAddr.getText() + "',acctype='" + txtAccType.getText() + "',contact='" + txtContact.getText() + "' WHERE userid='" + Id + "'");
                    JOptionPane.showMessageDialog(this, "Database Updated");
                    BankingMenu obj1 = new BankingMenu();
                    obj1.setVisible(true);
                    obj1.setSize(1368, 740);
                    setVisible(false);
                    dispose();
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Problem while Saving the Record");
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
