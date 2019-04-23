package banking.account;

import framework.account.AccountFactory;
import framework.account.IAccount;
import framework.party.Customer;

public abstract class BankAccountFactory  extends AccountFactory {
    public BankAccountFactory() throws Exception {
        super();
    }

    //private static BankAccountFactory accountFactory = null;

    //public static BankAccountFactory getInstance() {
        //if(accountFactory == null) {
            //accountFactory = new BankAccountFactory();
        //}

        //return accountFactory;
    //}

    public static IAccount createAccount(Customer customer, String accNumber, String type) {
        IAccount account = null;
        if (type.equals("checkings"))
            account = new Checkings(customer, accNumber);
        else if (type.equals("savings"))
            account = new Savings(customer, accNumber);

        customer.addAccount(account);
        return account;
    }
}
