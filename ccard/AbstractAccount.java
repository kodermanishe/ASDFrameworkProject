package ccard;

import framework.account.Account;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalField;
import java.util.Date;

public abstract class AbstractAccount extends Account {

    private Date exp_date;
    private Month last_month_Balance;
    private Double x;
    private Double y;


    public Double getLastMonthBalance(){
        final LocalDate lastMonth = LocalDate.now().minusMonths(1);
        final int year = lastMonth.getYear();
        final int month = lastMonth.getMonth().getValue();
        final int day = lastMonth.getDayOfMonth();

        return super.getEntries().stream()
                .filter(e -> e.date().isBefore(LocalDate.of(
                        year, month, day
                ))).mapToDouble(e -> e.amount()).sum();
    }


    public Double getTotalMonthlyCredits(){

        final LocalDate currentMonth = LocalDate.now();
        final int month = currentMonth.getMonth().getValue();

        return  super.getEntries().stream().filter(e->e.date().getMonth().getValue()==month && e.name().equals("deposit")).
                mapToDouble(e->e.amount()).sum();
    }


    public Double getLastMonthCharges(){

        final LocalDate currentMonth = LocalDate.now();
        final int month = currentMonth.getMonth().getValue();

        return  super.getEntries().stream().filter(e->e.date().getMonth().getValue()==month && e.name().equals("withdrawal")).
                mapToDouble(e->e.amount()).sum();

    }


    public abstract double getNewMonthlyBalance();
    public abstract double getMonthlyAmountDue();


}
