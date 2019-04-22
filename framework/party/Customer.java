package framework.party;

import framework.account.IAccount;

public interface Customer {
	public int getCountEmp();
	void SendEmailToCustomer();
	void addAccount(IAccount account);
	void removeAccount(IAccount account);
	String getName();
	String getStreet();
	String getCity();
	String getState();
	String getZip();
	String getEmail();
}
