package framework.party;

import framework.account.IAccount;

import java.util.List;

public interface Customer {
	public int getCountEmp();
	void SendEmailToCustomer();
	void addAccount(IAccount account);
	void removeAccount(IAccount account);
	String getName();
	String getStreet();
	String getCity();
	String getState();
	int getZip();
	String getEmail();
	CustomerType getType();
	List<IAccount> getAccounts();
}
