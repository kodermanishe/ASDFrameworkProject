package bank.account;

import bank.rules.BankRule;
import framework.account.Account;
import framework.party.Customer;

public abstract class AbstractAccount extends Account {

    protected double interest;

    public AbstractAccount(Customer customer, String accountNumber, double interest) {
        super(customer, accountNumber);
        this.interest = interest;
    }

    public AbstractAccount(Customer party, String accountNumber) {
        super(party, accountNumber);
    }


}
