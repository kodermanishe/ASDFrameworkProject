package creditcard.ui;

import java.awt.*;

import javax.swing.table.DefaultTableModel;

import creditcard.account.AbstractAccount;
import creditcard.facade_DB.CreditCardController;
import framework.account.IAccount;
import framework.party.Customer;

import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class CardFrm extends javax.swing.JFrame
{
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	CardFrm thisframe;
	private Object rowdata[];
	private CreditCardController facade;

	public DefaultTableModel getModel() {
		return model;
	}

	public CardFrm()
	{
		thisframe=this;
		this.facade = new CreditCardController();

		setTitle("Credit-card processing Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
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
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Cc Type");
		model.addColumn("Type");
		model.addColumn("Balance");


		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_AddInterest.setText("Add Interest");
		JPanel1.add(JButton_AddInterest);
		JButton_AddInterest.setBounds(468,204,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);


		JButton_GenBill.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_AddInterest.addActionListener(lSymAction);
	}


	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_AddInterest = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();


	void exitApplication()
	{
		try {
			this.setVisible(false);    // hide the Frame
			this.dispose();            // free the system resources
			System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == CardFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_AddInterest)
				JButtonAddInterest_actionPerformed(event);
		}
	}

	//When the Exit button is pressed this code gets executed
	//this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	public void updateTable() {
		model.setRowCount(0);
		for (IAccount account : facade.getAccounts()) {
			rowdata = new Object[model.getColumnCount()];
			Customer customer = account.getCustomer();
			rowdata[0] = customer.getName();
			rowdata[1] = account.getAccNumber();
			rowdata[2] = ((AbstractAccount)account).getExpDate();
			rowdata[3] = account.getType();
			rowdata[4] = customer.getType();
			rowdata[5] = account.getCurrentBalance();
			model.addRow(rowdata);
		}
	}

	void JButtonAddInterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		facade.addInterest();
		updateTable();
	}

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(this, facade);
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialogGenBill billFrm = new JDialogGenBill(this, facade);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >=0){
			String accountNumber = (String) model.getValueAt(selection, 1);
			//Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(this, accountNumber, facade);
			dep.setBounds(430, 15, 275, 140);
			dep.show();
		}
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >=0){
			String accountNumber = (String) model.getValueAt(selection, 1);
			//Show the dialog for adding deposit amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(this, accountNumber, facade);
			wd.setBounds(430, 15, 275, 140);
			wd.show();
		}
	}

}
