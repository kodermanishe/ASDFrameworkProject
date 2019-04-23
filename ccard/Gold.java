package ccard;

public class Gold  extends AbstractAccount{
    private  double MI=6;
    private  double MP=10;

    public double getNewMonthlyBalance(){
        return  super.getLastMonthBalance() - super.getTotalMonthlyCredits()  + super.getLastMonthCharges() * MI;
    }

    public double getMonthlyAmountDue(){
         return MP * getNewMonthlyBalance();
    }



}



