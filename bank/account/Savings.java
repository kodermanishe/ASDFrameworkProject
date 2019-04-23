package bank.account;

import bank.rules.BankRule;
import framework.party.Customer;

public class Savings extends AbstractAccount {
    public Savings(Customer customer, String accNumber) {
        super(customer, accNumber);
        interest = 0.1;
    }

    @Override
    public String getType() {
        return "savings";
    }

    @Override
    public void notifyCustomer() {
        if(new BankRule().test(this)) customer.SendEmailToCustomer();
    }
}