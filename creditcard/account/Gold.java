package creditcard.account;

import framework.party.Customer;

import java.time.LocalDate;

public class Gold extends AbstractAccount {

    private double interestRate = 0.06;
    private double mP = 0.10;

    public Gold(Customer party, String accountNumber, String date) {
        super(party, accountNumber, date);
    }

    public Gold(Customer party, String accountNumber) {
        super(party, accountNumber);
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



