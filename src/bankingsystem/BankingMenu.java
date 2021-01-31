package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class BankingMenu extends JFrame implements ActionListener, WindowListener {

    private JLabel bgPic;
    private JMenuBar mBar;
    private JMenu mnuCust, mnuTran, mnuUtil;
    private JMenuItem mnuAddCust, mnuEditCust, mnuDelCust, mnuDeposit, mnuWithdraw, mnuBalance;
    private int xSize, ySize, dSize;

    BankingMenu() {
        this.setTitle("Banking Menu Screen");
        Container cnt = getContentPane();

        cnt.setLayout(new BorderLayout());

        addWindowListener(this);

        xSize = 740;
        ySize = 740;
        dSize = 10;

        mBar = new JMenuBar();
        cnt.add("North", mBar);

        mnuCust = new JMenu("Customer");
        mnuCust.addSeparator();

        mnuTran = new JMenu("Transactions");
        mnuTran.addSeparator();

        mnuUtil = new JMenu("Utilities");
        mnuUtil.addSeparator();

        mnuAddCust = new JMenuItem("Add Customer Details");
        mnuEditCust = new JMenuItem("Edit Customer Details");
        mnuDelCust = new JMenuItem("Delete Customer Details");
        mnuDeposit = new JMenuItem("Deposit Money");
        mnuWithdraw = new JMenuItem("Withdraw Money");
        mnuBalance = new JMenuItem("Check Balance");

        mnuCust.setMnemonic(KeyEvent.VK_C);
        mnuTran.setMnemonic(KeyEvent.VK_T);
        mnuUtil.setMnemonic(KeyEvent.VK_U);

        mnuAddCust.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        mnuAddCust.setMnemonic((int) 'a');
        mnuEditCust.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
        mnuEditCust.setMnemonic((int) 'e');
        mnuDelCust.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
        mnuDelCust.setMnemonic((int) 'd');

        mnuDeposit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK));
        mnuDeposit.setMnemonic((int) 'm');
        mnuWithdraw.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.CTRL_MASK));
        mnuWithdraw.setMnemonic((int) 'w');
        mnuBalance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
        mnuBalance.setMnemonic((int) 'b');

        mnuCust.setForeground(Color.black);
        mnuAddCust.setForeground(Color.black);
        mnuEditCust.setForeground(Color.black);
        mnuDelCust.setForeground(Color.black);

        mnuTran.setForeground(Color.black);
        mnuDeposit.setForeground(Color.black);
        mnuWithdraw.setForeground(Color.black);

        mnuUtil.setForeground(Color.black);
        mnuBalance.setForeground(Color.black);

        mBar.add(mnuCust);
        mBar.add(mnuTran);
        mBar.add(mnuUtil);
        mnuCust.add(mnuAddCust);
        mnuCust.add(mnuEditCust);
        mnuCust.add(mnuDelCust);
        mnuTran.add(mnuDeposit);
        mnuTran.add(mnuWithdraw);
        mnuUtil.add(mnuBalance);

        mnuCust.addSeparator();
        mnuTran.addSeparator();
        mnuUtil.addSeparator();

        mnuAddCust.addActionListener(this);
        mnuEditCust.addActionListener(this);
        mnuDelCust.addActionListener(this);
        mnuDeposit.addActionListener(this);
        mnuWithdraw.addActionListener(this);
        mnuBalance.addActionListener(this);

        bgPic = new javax.swing.JLabel();
        bgPic.setIcon(new javax.swing.ImageIcon("bankmenu.jpg"));
        cnt.add(bgPic);
        bgPic.setBounds(200, 200, 1400, 800);

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
        if (mnuAddCust.isArmed()) {
            Account acc = new Account();
            acc.setSize(1368, 740);
            acc.setTitle("Add Customer Details");
            acc.setVisible(true);
            setVisible(false);
            dispose();
        }

        if (mnuEditCust.isArmed()) {
            EditCustomer edc = new EditCustomer();
            edc.setSize(1368, 740);
            edc.setTitle("Edit Customer Details");
            edc.setVisible(true);
            setVisible(false);
            dispose();
        }
        if (mnuDelCust.isArmed()) {
            DeleteCustomer delc = new DeleteCustomer();
            delc.setSize(1368, 740);
            delc.setTitle("Delete Customer Details");
            delc.setVisible(true);
            setVisible(false);
            dispose();
        }
        if (mnuDeposit.isArmed()) {
            DepositMoney dep = new DepositMoney();
            dep.setSize(1368, 740);
            dep.setTitle("Deposit Money");
            dep.setVisible(true);
            setVisible(false);
            dispose();
        }
        if (mnuWithdraw.isArmed()) {
            WithdrawMoney wthdrw = new WithdrawMoney();
            wthdrw.setSize(1368, 740);
            wthdrw.setTitle("Withdraw Money");
            wthdrw.setVisible(true);
            setVisible(false);
            dispose();
        }
        if (mnuBalance.isArmed()) {
            CheckBalance chkbal = new CheckBalance();
            chkbal.setSize(1368, 740);
            chkbal.setTitle("Check Balance");
            chkbal.setVisible(true);
            setVisible(false);
            dispose();
        }

    }
}
