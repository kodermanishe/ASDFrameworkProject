package framework.ui;

import framework.facade_DB.Controller;
import framework.account.IAccount;

import javax.swing.*;
import java.awt.*;

public class JDialog_Deposit extends JDialog
{

    private Controller controller;
    private IAccount account;
    
	public JDialog_Deposit(MainScreen main, IAccount account, Controller controller)
	{
		super(main);
		this.controller = controller;
		this.account = account;

		//{{ INIT_CONTROLS 
		setTitle("Deposit");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268,126);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,48,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,144,24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84,48,144,24);
		//}}
	    JTextField_NAME.setText(account.getAccNumber());
	    
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}



	//{{DECLARE_CONTROLS
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JTextField JTextField_Deposit = new JTextField();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		double money = Double.parseDouble(JTextField_Deposit.getText());
		controller.deposit(account, money);
		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}

}