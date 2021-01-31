package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BankingSystem extends JFrame implements ActionListener, WindowListener {

    private JLabel lblTitle, bgPic;
    private JButton btn;
    private JPanel jPanl;
    private int xSize, ySize, dSize;
    Container cntPane;
    Font fnt;

    public BankingSystem() {

        cntPane = this.getContentPane();
        addWindowListener(this);
        xSize = 440;
        ySize = 440;
        dSize = 10;
        jPanl = new JPanel();
        jPanl.setLayout(null);

        lblTitle = new JLabel("WELCOME TO BANKING SYSTEM");
        btn = new JButton("ENTER");

        fnt = new Font("Times New Roman", Font.BOLD, 35);
        lblTitle.setFont(fnt);

        lblTitle.setBounds(300, 30, 600, 500);

        btn.setBounds(520, 350, 150, 30);

        lblTitle.setForeground(Color.RED);

        bgPic = new javax.swing.JLabel();
        bgPic.setIcon(new javax.swing.ImageIcon("bank.jpg"));
        cntPane.add(bgPic);
        bgPic.setBounds(10, 20, 1400, 700);

        jPanl.add(lblTitle);
        jPanl.add(bgPic);
        jPanl.add(btn);

        cntPane.add(jPanl);
        btn.addActionListener(this);
    }

    public void windowClosed(WindowEvent we) {
    }

    public void windowDeiconified(WindowEvent we) {
    }

    public void windowIconified(WindowEvent we) {
    }

    public void windowActivated(WindowEvent we) {
    }

    public void windowDeactivated(WindowEvent we) {
    }

    public void windowOpened(WindowEvent we) {
    }

    public void windowClosing(WindowEvent we) {
        while (xSize > 0 && ySize > 0) {
            setSize(xSize, ySize);
            xSize = xSize - dSize;
            ySize = ySize - dSize;
            show();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        BankingLogin mnu = new BankingLogin();
        mnu.setVisible(true);
        mnu.setSize(1368, 740);
        setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        BankingSystem bSys = new BankingSystem();
        bSys.setVisible(true);
        bSys.setTitle("Welcome Screen");
        bSys.setSize(1368, 740);
    }

}
