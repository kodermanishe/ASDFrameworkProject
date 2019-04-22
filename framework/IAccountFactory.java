package framework;

import framework.account.Account;
import framework.party.AbstractCustomer;

public interface IAccountFactory {
	public Account createAccount(AbstractCustomer party, String accountNumber, String type);
}
