package framework.rules;

import framework.account.IAccount;

public interface Rule {
	public boolean test(IAccount account);
}
