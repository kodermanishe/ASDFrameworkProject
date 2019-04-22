package framework.rules;

import framework.account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NotifyRule implements INotifyRule{
	private List<Predicate<Account>> rules = new ArrayList<>();
	
	public NotifyRule() {
		rules.add(new Predicate<Account>() {
			@Override
			public boolean test(Account t) {
				return true;
			}
		});
	}
	
	@Override
	public boolean chech(Account account) {
		for(Predicate<Account> predicate: rules) {
			if(predicate.test(account)) return true;
		}
		
		return false;
	}

}
