package bank.ui;

import framework.account.IAccount;
import framework.party.CustomerType;
import framework.rules.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BankRule implements Rule {
    private List<Predicate<IAccount>> rulesC = new ArrayList<>();
    private List<Predicate<IAccount>> rulesP = new ArrayList<>();

    public BankRule() {
        rulesC.add(new Predicate<IAccount>() {
            @Override
            public boolean test(IAccount t) {

                return true;
            }
        });

        rulesP.add(new Predicate<IAccount>() {
            @Override
            public boolean test(IAccount account) {
                double lastAmount = account.getLastAmountTransaction();
                if (lastAmount > 500 && lastAmount < 0)
                    return true;
                else
                    return false;
            }
        });
    }

    @Override
    public boolean test(IAccount account) {
        if (account.getCustomer().getType() == CustomerType.COMPANY)
        for(Predicate<IAccount> predicate: rulesC) {
            if(predicate.test(account))
                return true;
        }
        else if (account.getCustomer().getType() == CustomerType.COMPANY)
            for(Predicate<IAccount> predicate: rulesP) {
                if(predicate.test(account))
                    return true;
            }

        return false;
    }
}
