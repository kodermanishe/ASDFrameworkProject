package ccard;

public class Silver extends AbstractAccount {


    private  double MI=8;
    private  double MP=12;

    public double getNewMonthlyBalance(){
        return  super.getLastMonthBalance() - super.getTotalMonthlyCredits()  + super.getLastMonthCharges() * MI;
    }

    public double getMonthlyAmountDue(){
        return MP * getNewMonthlyBalance();
    }


}
