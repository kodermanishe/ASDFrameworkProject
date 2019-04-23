package creditcard.account;

import framework.party.Customer;

import java.time.LocalDate;

public class Silver extends AbstractAccount {

    private double interestRate = 0.08;
    private double mP = 0.12;

    public Silver(Customer party, String accountNumber, String date) {
        super(party, accountNumber, date);
    }

    public Silver(Customer party, String accountNumber) {
        super(party, accountNumber);
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



