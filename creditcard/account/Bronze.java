package creditcard.account;

import framework.account.Account;
import framework.party.Customer;

import java.time.LocalDate;

public class Bronze extends Account {
    private double mP = 0.14;

    public Bronze(Customer party, String accountNumber, String date) {
        super(party, accountNumber);
        expDate = date;
        interest = 0.10;
    }
    public Bronze(Customer party, String accountNumber) {
        super(party, accountNumber);
        interest = 0.10;
    }

    @Override
    public String getType() {
        return "bronze";
    }

    @Override
    public double getMP() {
        return mP;
    }


}



