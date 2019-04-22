package framework.party;

import framework.account.IAccount;

import java.util.List;

public interface ICompany {
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public void notifyOwner();
	public List<IAccount> getAccounts();
}
