package framework.account;

import framework.party.Customer;

public abstract class AccountFactory{
	
	public AccountFactory() throws Exception {
		throw new Exception();
	}
	//private static AccountFactory accountFactory = null;
	
	//public static AccountFactory getInstance() {
		//if(accountFactory == null) {
			//accountFactory = new AccountFactory();
		//}
		
		//return accountFactory;
	//}

	public static IAccount createAccount(Customer customer, String accNumber, String type) {
		IAccount account = new Account(customer, accNumber);
		customer.addAccount(account);
		return account;
	}
}
