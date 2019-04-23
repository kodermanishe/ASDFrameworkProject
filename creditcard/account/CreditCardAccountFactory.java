package creditcard.account;

import framework.account.AccountFactory;
import framework.account.IAccount;
import framework.party.Customer;


public abstract class CreditCardAccountFactory extends AccountFactory {
    public CreditCardAccountFactory() throws Exception {
        super();
    }

    //private static CreditCardAccountFactory accountFactory = null;

    //public static CreditCardAccountFactory getInstance() {
        //if(accountFactory == null) {
            //accountFactory = new CreditCardAccountFactory();
        //}

        //return accountFactory;
    //}

    public static IAccount createAccount(Customer customer, String accountNumber, String expDate, String type) {
        IAccount account = null;
        if (type.equals("gold"))
            account = new Gold(customer, accountNumber, expDate);
        else if (type.equals("silver"))
            account = new Silver(customer, accountNumber, expDate);
        else if (type.equals("bronze"))
            account = new Bronze(customer, accountNumber, expDate);

        customer.addAccount(account);

        return account;
    }

    public static IAccount createAccount(Customer customer, String accNumber, String type) {
        IAccount account = null;
        if (type.equals("gold"))
            account = new Gold(customer, accNumber);
        else if (type.equals("silver"))
            account = new Silver(customer, accNumber);
        else if (type.equals("bronze"))
            account = new Bronze(customer, accNumber);

        customer.addAccount(account);
        return account;
    }
}
