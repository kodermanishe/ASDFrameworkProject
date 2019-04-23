package bank.ui;

import framework.account.IAccount;
import framework.rules.Rule;

public class BankRule implements Rule {
    @Override
    public boolean test(IAccount account) {
        return false;
    }
}
