package framework;

import framework.account.Account;
import framework.party.AbstractCustomer;

public class AccountFactory implements IAccountFactory{
	
	protected AccountFactory() {}
	private static AccountFactory accountFactory = null;
	
	public static AccountFactory getInstance() {
		if(accountFactory == null) {
			accountFactory = new AccountFactory();
		}
		
		return accountFactory;
	}
	
	public Account createAccount(AbstractCustomer party, String accountNumber, String type) {
		Account account = new Account(party, accountNumber);
		party.addAccount(account);
		return account;
	}
}
