package creditcard.rules;

import framework.account.IAccount;
import framework.party.CustomerType;
import framework.rules.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CreditCardRule implements Rule {
    private List<Predicate<IAccount>> rules = new ArrayList<>();

    public CreditCardRule() {

        rules.add(new Predicate<IAccount>() {
            @Override
            public boolean test(IAccount account) {
                double lastAmount = account.getLastAmountTransaction();
                if (lastAmount > 400)
                    return true;
                else
                    return false;
            }
        });
    }

    @Override
    public boolean test(IAccount account) {

        if (account.getCustomer().getType() == CustomerType.PERSON)
            for(Predicate<IAccount> predicate: rules) {
                if(predicate.test(account))
                    return true;
            }

        return false;
    }
}
