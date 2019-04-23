package banking.ui;

import banking.facade_DB.BankFacade;
import framework.account.IAccount;
import framework.party.Customer;
import framework.ui.MainScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class BankFrm extends MainScreen
{
    /****
     * init variables in the object
     ****/
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	BankFrm myframe;
	private Object rowdata[];
	private BankFacade facade;

	JPanel JPanel1 = new JPanel();
	JButton JButton_NewCCAccount = new JButton();
	JButton JButton_GenBill = new JButton();
	JButton JButton_Deposit = new JButton();
	JButton JButton_Withdraw = new JButton();
	JButton JButton_Exit = new JButton();


	public BankFrm()
	{
		myframe = this;
		this.facade = new BankFacade();
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

		JButton_GenBill.setText("Report");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(468,204,96,33);

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
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_AddInterest.addActionListener(lSymAction);

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
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
		}
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialogGenBill billFrm = new JDialogGenBill(facade);
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();

	}

	protected void JButtonWithdraw_actionPerformed(ActionEvent event)
	{
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >=0){
			String accountNumber = (String) model.getValueAt(selection, 0);

			JDialog_Withdraw wd = new JDialog_Withdraw(this, accountNumber, facade);
			wd.setBounds(430, 15, 275, 140);
			wd.setVisible(true);

			// compute new amount
			this.updateTable();
		}


	}

	protected void JButtonDeposit_actionPerformed(ActionEvent event)
	{
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0){
			String accountNumber = (String) model.getValueAt(selection, 0);

			//Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(this, accountNumber, facade);
			dep.setBounds(430, 15, 275, 140);
			dep.setVisible(true);

			// compute new amount
			this.updateTable();
		}
	}

	protected void JButtonAddinterest_actionPerformed(ActionEvent event)
	{
		facade.addInterest();
		this.updateTable();
		JOptionPane.showMessageDialog(JButton_AddInterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
	}

	@Override
	protected void JButtonPerAC_actionPerformed(ActionEvent event)
	{
		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe, facade);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);

		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}

	@Override
	protected void JButtonCompAC_actionPerformed(ActionEvent event)
	{
		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe, facade);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);

		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}

	@Override
	protected DefaultTableModel getModel() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Street");
		model.addColumn("City");
		model.addColumn("State");
		model.addColumn("P/C");
		model.addColumn("Amount");
		return model;
	}

	@Override
	public void updateTable() {
		model.setRowCount(0);
		for (IAccount account : facade.getAccounts()) {
			IAccount bankAccount = account;
			rowdata = new Object[model.getColumnCount()];
			Customer customer = account.getCustomer();
			rowdata[0] = bankAccount.getAccNumber();
			rowdata[1] = customer.getName();
			rowdata[2] = bankAccount.getType();
			rowdata[3] = customer.getStreet();
			rowdata[4] = customer.getCity();
			rowdata[5] = customer.getState();
			rowdata[6] = customer.getType();
			rowdata[7] = bankAccount.getCurrentBalance();
			model.addRow(rowdata);
		}
	}
}
