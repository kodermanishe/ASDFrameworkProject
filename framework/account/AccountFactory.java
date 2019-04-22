package framework.account;

import framework.party.Customer;

public class AccountFactory implements IAccountFactory {
	
	protected AccountFactory() {}
	private static AccountFactory accountFactory = null;
	
	public static AccountFactory getInstance() {
		if(accountFactory == null) {
			accountFactory = new AccountFactory();
		}
		
		return accountFactory;
	}

	@Override
	public IAccount createAccount(Customer customer, int accNumber, String type) {
		Account account = new Account(customer, accNumber);
		customer.addAccount(account);
		return account;
	}
}
