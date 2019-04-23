package bank.ui;

import framework.account.Account;
import framework.party.Customer;

public abstract class AbstractAccount extends Account {

    private double interest;

    public AbstractAccount(Customer customer, String accountNumber, double interest) {
        super(customer, accountNumber);
        this.interest = interest;
    }

    public AbstractAccount(Customer party, String accountNumber) {
        super(party, accountNumber);
    }

    public abstract String getType();

    public void sendNotification() {
        if(new BankRule().test(this)) customer.SendEmailToCustomer();
    }
}
