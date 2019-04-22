package framework.rules;


import framework.account.Account;
import framework.account.IAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NotifyRule implements Rule {
	private List<Predicate<IAccount>> rules = new ArrayList<>();
	
	public NotifyRule() {
		rules.add(new Predicate<IAccount>() {
			@Override
			public boolean test(IAccount t) {

				return true;
			}
		});
	}
	
	@Override
	public boolean test(IAccount account) {
		for(Predicate<IAccount> predicate: rules) {
			if(predicate.test(account))
				return true;
		}
		
		return false;
	}

}
