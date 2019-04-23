package creditcard.account;

import framework.account.Account;
import framework.party.Customer;

import java.time.LocalDate;

public abstract class AbstractAccount extends Account {

    private String expDate;

    public String getExpDate() {
        return expDate;
    }

    public AbstractAccount(Customer party, String accountNumber, String expDate) {
        super(party, accountNumber);
        this.expDate = expDate;
    }

    public AbstractAccount(Customer party, String accountNumber) {
        super(party, accountNumber);
    }

    public abstract double getMP();

    public double getLastMonthBalance(){
        LocalDate d = LocalDate.now().minusMonths(1);
        LocalDate end = d.withDayOfMonth(d.lengthOfMonth());
        return getEntries().stream().filter(e -> e.getDate().isBefore(end))
                .mapToDouble(e -> e.getAmount()).sum();
    }

    public double getTotalCredits(){
        LocalDate d = LocalDate.now();
        LocalDate st = d.withDayOfMonth(1);
        LocalDate end = d.withDayOfMonth(d.lengthOfMonth());
        return getEntries().stream().filter(e -> e.getName().equals("deposit")
                && e.getDate().isAfter(st) && e.getDate().isBefore(end))
                .mapToDouble(e -> e.getAmount()).sum();
    }

    public double getCharges(){
        LocalDate d = LocalDate.now();
        LocalDate st = d.withDayOfMonth(1);
        LocalDate end = d.withDayOfMonth(d.lengthOfMonth());
        return getEntries().stream().filter(e -> e.getName().equals("withdraw")
                && e.getDate().isAfter(st) && e.getDate().isBefore(end))
                .mapToDouble(e -> e.getAmount()).sum()*(-1);
    }

    public double getNewMonthlyBalance(){
        return getLastMonthBalance() - getTotalCredits() + getCharges()
                + getInterest() * (getLastMonthBalance() - getTotalCredits());
    }

    public double getMonthlyAmountDue(){
        return getMP() * getNewMonthlyBalance();
    }


}
