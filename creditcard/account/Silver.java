package creditcard.account;

import framework.account.Account;
import framework.party.Customer;

import java.time.LocalDate;

public class Silver extends Account {
    private double mP = 0.12;

    public Silver(Customer party, String accountNumber, String date) {
        super(party, accountNumber);
        expDate = date;
        interest = 0.08;
    }

    public Silver(Customer party, String accountNumber) {
        super(party, accountNumber);
        interest = 0.08;
    }

    @Override
    public String getType() {
        return "silver";
    }

    @Override
    public double getMP() {
        return mP;
    }
}



