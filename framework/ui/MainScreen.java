package framework.ui;

import framework.FinCo;
import framework.account.Account;
import framework.party.AbstractCustomer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class MainScreen extends JFrame{
	
	MainScreen myframe;
	public String accountnr, clientName, street, city, zip, state, accountType, amountDeposit;
	protected JPanel JPanel1 = new JPanel();
    protected JButton JButton_PerAC = new JButton();
    protected JButton JButton_CompAC = new JButton();
    protected JButton JButton_Deposit = new JButton();
    protected JButton JButton_Withdraw = new JButton();
    protected JButton JButton_AddInterest = new JButton();
    protected JButton JButton_Exit = new JButton();
    private JScrollPane JScrollPane1;
    private JTable JTable1;
    protected DefaultTableModel model;
    public FinCo finCo;
    private Object rowdata[];
    public boolean newAccount;

    public MainScreen(){}
	public MainScreen(FinCo finCo) {
		myframe = this;
		this.finCo = finCo;
		setTitle(getTitle());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(590,330);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,575,310);

        /*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = getModel();
        JTable1 = new JTable(model);
        rowdata = new Object[model.getColumnCount()];
        System.out.println(model.getRowCount());

        newAccount = false;

        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);

        JButton_PerAC.setText("Add personal account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24,20,192,33);
        JButton_PerAC.setActionCommand("jbutton");

        JButton_CompAC.setText("Add company account");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240,20,192,33);
        JButton_CompAC.setActionCommand("jbutton");

        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468,104,96,33);

        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468,164,96,33);

        JButton_AddInterest.setText("Add interest");
        JPanel1.add(JButton_AddInterest);
        JButton_AddInterest.setBounds(448,20,106,33);

        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468,248,96,31);


        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        JButton_AddInterest.addActionListener(lSymAction);
	}
	
    protected DefaultTableModel getModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("State");
        model.addColumn("P/C");
        model.addColumn("Amount");
        return model;
    }
    
    public class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(WindowEvent event)
        {
            Object object = event.getSource();
            if (object == MainScreen.this)
                FinCo_windowClosing(event);
        }
    }
    
    protected void FinCo_windowClosing(WindowEvent event)
    {
        FinCo_windowClosing_Interaction1(event);
    }

    protected void FinCo_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    protected void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }
    
    public class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_PerAC)
                JButtonPerAC_actionPerformed(event);
            else if (object == JButton_CompAC)
                JButtonCompAC_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);
            else if (object == JButton_AddInterest)
                JButtonAddinterest_actionPerformed(event);

        }
    }
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    protected void JButtonExit_actionPerformed(ActionEvent event)
    {
        System.exit(0);
    }

    protected void JButtonPerAC_actionPerformed(ActionEvent event)
    {
        JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.setVisible(true);

        JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
    }

    protected void JButtonCompAC_actionPerformed(ActionEvent event)
    {
        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.setVisible(true);

        JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
    }

    protected void JButtonDeposit_actionPerformed(ActionEvent event)
    {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0){
            String accountNumber = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            JDialog_Deposit dep = new JDialog_Deposit(this, finCo.getAccountByNumber(accountNumber));
            dep.setBounds(430, 15, 275, 140);
            dep.setVisible(true);

            // compute new amount
            this.updateTable();
        }
    }

    protected void JButtonWithdraw_actionPerformed(ActionEvent event)
    {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accountNumber = (String) model.getValueAt(selection, 0);

            JDialog_Withdraw wd = new JDialog_Withdraw(this, finCo.getAccountByNumber(accountNumber));
            wd.setBounds(430, 15, 275, 140);
            wd.setVisible(true);

            // compute new amount
            this.updateTable();
        }


    }

    protected void JButtonAddinterest_actionPerformed(ActionEvent event)
    {
        finCo.addInterest();
        this.updateTable();
        JOptionPane.showMessageDialog(JButton_AddInterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
    }

    public void updateTable() {
        model.setRowCount(0);

        for (Account account : finCo.getAccounts()) {
            rowdata = new Object[model.getColumnCount()];
            rowdata[0] = account.getAccountNumber();
            rowdata[1] = ((AbstractCustomer)account.getOwner()).getName();
            rowdata[2] = ((AbstractCustomer)account.getOwner()).getCity();
            rowdata[3] = ((AbstractCustomer)account.getOwner()).getState();
            rowdata[4] = ((AbstractCustomer)account.getOwner()).getClass().getSimpleName();
            rowdata[5] = account.getBalance();
            model.addRow(rowdata);
        }
    }
}
