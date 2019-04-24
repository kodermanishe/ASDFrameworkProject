package banking.account;

import banking.rules.BankRule;
import framework.account.Account;
import framework.party.Customer;

public class Checkings extends Account {

    public Checkings(Customer customer, String accNumber) {
        super(customer, accNumber);
        super.interest = 0.5;
    }

    @Override
    public String getType() {
        return "checkings";
    }

    @Override
    public void notifyCustomer() {
        if(new BankRule().test(this)) customer.SendEmailToCustomer();
    }
}
