package banking.account;

import banking.rules.BankRule;
import framework.account.Account;
import framework.party.Customer;

public class Savings extends Account {
    public Savings(Customer customer, String accNumber) {
        super(customer, accNumber);
        super.interest = 0.7;
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
