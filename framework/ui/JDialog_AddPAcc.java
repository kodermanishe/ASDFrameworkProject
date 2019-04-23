package framework.ui; /**
		A basic implementation of the JDialog class.
**/

import framework.facade_DB.Controller;
import framework.party.Customer;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class JDialog_AddPAcc extends JDialog
{
    private MainScreen main;
    Controller controller;
    
	public JDialog_AddPAcc(MainScreen main, Controller controller)
	{
		this.main = main;
		this.controller = controller;

		//{{ INIT_CONTROLS 
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283,303);
		setVisible(false);

		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(Color.black);
		JLabel1.setBounds(12,40,80,24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(Color.black);
		JLabel2.setBounds(12,70,80,24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(Color.black);
		JLabel3.setBounds(12,100,80,24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(Color.black);
		JLabel4.setBounds(12,130,80,24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(Color.black);
		JLabel5.setBounds(12,160,80,24);
		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(Color.black);
		JLabel6.setBounds(12,190,80,24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(Color.black);
		JLabel7.setBounds(12,220,80,24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(100,40,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(100,70,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(100,100,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(100,130,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(100,160,156,20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(100,190,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_BD.setText("1/01/1990");
		JTextField_EM.setBounds(100,220,156,20);

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,264,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,264,84,24);

		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(100,10,156,20);
		JLabel8.setText("Account number");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(Color.black);
		JLabel8.setBounds(12,10,80,24);
		//}}
	
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}

	//{{DECLARE_CONTROLS
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JLabel JLabel3 = new JLabel();
	JLabel JLabel4 = new JLabel();
	JLabel JLabel5 = new JLabel();
	JLabel JLabel6 = new JLabel();
	JLabel JLabel7 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JTextField JTextField_CT = new JTextField();
	JTextField JTextField_ST = new JTextField();
	JTextField JTextField_STR = new JTextField();
	JTextField JTextField_ZIP = new JTextField();
	JTextField JTextField_BD = new JTextField();
	JTextField JTextField_EM = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JTextField JTextField_ACNR = new JTextField();
	JLabel JLabel8 = new JLabel();
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String accountNumber = JTextField_ACNR.getText();
		String name = JTextField_NAME.getText();
		String street = JTextField_STR.getText();
		String city = JTextField_CT.getText();
		String state = JTextField_ST.getText();
		int zip = Integer.parseInt(JTextField_ZIP.getText());
		String email = JTextField_EM.getText();
		LocalDate birthDay = LocalDate.parse(JTextField_BD.getText(), formatter);

		Customer company = controller.createPerson(name, street, city, state, zip, email, birthDay, accountNumber);
		if (Objects.isNull(company)){
			JOptionPane.showMessageDialog(this, "Cannot create account, account number is exists","Error!", JOptionPane.ERROR_MESSAGE);
		}else{
			controller.createAccount(company, accountNumber, "");
			main.updateTable();
		}
		dispose();

	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
	    dispose();
	}
}