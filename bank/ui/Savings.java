package bank.ui;

import framework.party.Customer;

public class Savings extends AbstractAccount {
    public Savings(Customer customer, String accNumber) {
        super(customer, accNumber);
    }

    @Override
    public String getType() {
        return "savings";
    }
}
