package banking.account;

import banking.rules.BankRule;
import framework.party.Customer;

public class Checkings extends AbstractAccount {

    public Checkings(Customer customer, String accNumber) {
        super(customer, accNumber);
        interest = 0.5;
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
