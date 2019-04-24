package creditcard.account;

import framework.account.Account;
import framework.party.Customer;

import java.time.LocalDate;

public class Gold extends Account {
    private double mP = 0.10;

    public Gold(Customer party, String accountNumber, String date) {
        super(party, accountNumber);
        expDate = date;
        interest = 0.06;
    }

    public Gold(Customer party, String accountNumber) {
        super(party, accountNumber);
        interest = 0.06;
    }

    @Override
    public String getType() {
        return "gold";
    }

    @Override
    public double getMP() {
        return mP;
    }



}



