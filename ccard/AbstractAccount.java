package ccard;

import framework.account.Account;

import java.time.Month;
import java.util.Date;

public abstract class AbstractAccount extends Account {

    private Date exp_date;
    private Month last_month_Balance;
    private Double x;
    private Double y;


    public Double getLastMonthBalance(){

        return  0.0;

    }


    public void getTotalMonthlyCredits(){
    }


    public void getLastMonthCharges(){
    }


    public abstract void getNewMonthlyBalance();
    public abstract void getMonthlyAmountDue();


}
