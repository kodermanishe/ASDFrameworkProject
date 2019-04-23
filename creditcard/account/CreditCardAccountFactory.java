package creditcard.account;

import framework.account.Account;
import framework.account.IAccount;
import framework.account.IAccountFactory;
import framework.party.Customer;

import java.time.LocalDate;

public class CreditCardAccountFactory implements IAccountFactory {
    private CreditCardAccountFactory() {}
    private static CreditCardAccountFactory accountFactory = null;

    public static CreditCardAccountFactory getInstance() {
        if(accountFactory == null) {
            accountFactory = new CreditCardAccountFactory();
        }

        return accountFactory;
    }

    public IAccount createAccount(Customer customer, String accountNumber, String expDate, String type) {
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

    @Override
    public IAccount createAccount(Customer customer, String accNumber, String type) {
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
