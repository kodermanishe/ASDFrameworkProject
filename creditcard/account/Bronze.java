package creditcard.account;

import framework.party.Customer;

import java.time.LocalDate;

public class Bronze extends AbstractAccount {

    private double interestRate = 0.10;
    private double mP = 0.14;

    public Bronze(Customer party, String accountNumber, String date) {
        super(party, accountNumber, date);
    }
    public Bronze(Customer party, String accountNumber) {
        super(party, accountNumber);
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



