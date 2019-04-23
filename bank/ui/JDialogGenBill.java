package bank.ui;

import bank.facade_DB.BankFacade;
import framework.account.IAccount;
import framework.account.entry.IEntry;
import framework.party.Customer;

import javax.swing.*;
import java.time.LocalDate;

public class JDialogGenBill extends JDialog
{
	private BankFacade facade;

	public JDialogGenBill(BankFacade facade)
	{
		this.facade = facade;
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parses  your Java file into its visual envirenment.
		//{{ INIT_CONTROLS
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);

		// generate the string for the monthly bill

		String billstring = "";
		double previousBalance, totalCharges, totalCredits;
		for(Customer customer: facade.getCustomers()) {
			billstring += "Name= "+customer.getName()+"\r\n";
			previousBalance = 0; totalCharges = 0; totalCredits = 0;
			for(IAccount account: customer.getAccounts()) {
				IAccount ccAccount = account;

				for(IEntry entry: ccAccount.getEntries()) {
					if(entry.date().getMonthValue()<LocalDate.now().getMonthValue()) {
						previousBalance += entry.amount();
					}
					if(entry.date().getMonthValue()==LocalDate.now().getMonthValue()) {
						if(entry.name().equals("withdraw")) totalCharges += -1*entry.amount();
						else if(entry.name().equals("deposit")) totalCredits += entry.amount();
					}
				}

				billstring += "CC number = "+ccAccount.getAccNumber()+"\r\n";
				billstring += "CC number = "+ccAccount.getType()+"\r\n";
				billstring += "Total Deposit = $"+totalCredits+"\r\n";
				billstring += "Total Withdraw = $"+totalCharges+"\r\n";
				billstring += "New balance = $"+(totalCredits-totalCharges)+"\r\n";
				billstring += "\r\n";
				billstring += "\r\n";
			}
		}

		JTextField1.setText(billstring);
		//}}

		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		//}}
	}

	//{{DECLARE_CONTROLS
	JScrollPane JScrollPane1 = new JScrollPane();
	JTextArea JTextField1 = new JTextArea();
	JButton JButton_OK = new JButton();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}
