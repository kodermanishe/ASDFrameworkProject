package banking.account;

import framework.account.Account;
import framework.party.Customer;

public abstract class AbstractAccount extends Account {

    public AbstractAccount(Customer customer, String accountNumber, double inter) {
        super(customer, accountNumber);
        interest = inter;
    }

    public AbstractAccount(Customer party, String accountNumber) {
        super(party, accountNumber);
    }


}
