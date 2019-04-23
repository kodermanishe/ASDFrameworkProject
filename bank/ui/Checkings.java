package bank.ui;

import framework.party.Customer;

public class Checkings extends AbstractAccount {

    public Checkings(Customer customer, String accNumber) {
        super(customer, accNumber);
    }

    @Override
    public String getType() {
        return "checkings";
    }
}
