package ccard;

public class bronze extends AbstractAccount{

    private  double MI=10;
    private  double MP=14;

    public double getNewMonthlyBalance(){
        return  super.getLastMonthBalance() - super.getTotalMonthlyCredits()  + super.getLastMonthCharges() * MI;
    }

    public double getMonthlyAmountDue(){
        return MP * getNewMonthlyBalance();
    }


}
