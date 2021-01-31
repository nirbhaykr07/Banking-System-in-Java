package bankingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class BankingLogin extends JFrame implements ActionListener {

    Container cntPane;
    private JPanel jpnl;
    private JLabel lbluser, lblpasswd, bgPic, lblSign;
    private JTextField txtuser;
    private JPasswordField txtpasswd;
    private JButton btnok, btncancel;
    Font fnt;

    BankingLogin() {
        this.setTitle("Login Screen");
        cntPane = this.getContentPane();
        lblSign = new JLabel("SIGN IN");
        lbluser = new JLabel("Username:");
        lblpasswd = new JLabel("Password:");
        txtuser = new JTextField();
        txtpasswd = new JPasswordField();
        btnok = new JButton("OK");
        btncancel = new JButton("Cancel");
        fnt = new Font("Times New Roman", Font.BOLD, 25);
        lbluser.setForeground(Color.black);
        lbluser.setForeground(Color.black);
        lblpasswd.setForeground(Color.black);
        btnok.setForeground(Color.black);
        btncancel.setForeground(Color.black);
        lbluser.setBounds(600, 280, 75, 25);
        lblpasswd.setBounds(600, 325, 75, 25);
        txtuser.setBounds(680, 280, 150, 25);
        txtpasswd.setBounds(680, 325, 150, 25);
        btnok.setBounds(600, 370, 100, 25);
        btncancel.setBounds(730, 370, 100, 25);

        btnok.addActionListener(this);
        btncancel.addActionListener(this);

        jpnl = new JPanel();
        jpnl.setLayout(null);
        lblSign.setFont(fnt);
        jpnl.add(lblSign);
        lblSign.setForeground(Color.red);
        lblSign.setBounds(700, 200, 250, 50);
        jpnl.add(lbluser);
        jpnl.add(lblpasswd);
        jpnl.add(txtuser);
        jpnl.add(txtpasswd);
        jpnl.add(btnok);
        jpnl.add(btncancel);
        bgPic = new javax.swing.JLabel();
        bgPic.setIcon(new javax.swing.ImageIcon("lock.JPG"));
        cntPane.add(bgPic);
        bgPic.setBounds(100, 100, 500, 500);

        cntPane.add(jpnl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnok) {
            String password = new String(txtpasswd.getPassword());
            if (txtuser.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Username field can't be left blank");
                txtuser.requestFocus();
            } else if (password.equals("")) {
                txtpasswd.requestFocus();
                JOptionPane.showMessageDialog(null, "Password field can't be left blank");
            } else {
                String pass, user, strUsr;
                strUsr = txtuser.getText();
                try {
                    Statement stmt = DBConnection.getConnection().createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE username='" + strUsr + "'");
                    rs.next();
                    user = rs.getString(1);
                    pass = rs.getString(2);
                    rs.close();
                    stmt.close();
                    if (txtuser.getText().equals(user) && password.equals(pass)) {
                        JOptionPane.showMessageDialog(this, "Login successful");
                        BankingMenu bmnu = new BankingMenu();
                        bmnu.setSize(1368, 740);
                        bmnu.setVisible(true);
                        setVisible(false);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong password");
                        txtuser.setText("");
                        txtpasswd.setText("");
                        txtuser.requestFocus();
                    }
                } catch (Exception sqlex) {
                    sqlex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Wrong username");
                    txtuser.setText("");
                    txtpasswd.setText("");
                    txtuser.requestFocus();
                }
            }
        } else if (obj == btncancel) {
            setVisible(false);
            dispose();
            System.exit(0);
        }

    }

}
