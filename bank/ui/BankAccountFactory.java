package bank.ui;

import framework.account.Account;
import framework.account.IAccount;
import framework.account.IAccountFactory;
import framework.party.Customer;

public class BankAccountFactory implements IAccountFactory {
    private BankAccountFactory() {}
    private static BankAccountFactory accountFactory = null;

    public static BankAccountFactory getInstance() {
        if(accountFactory == null) {
            accountFactory = new BankAccountFactory();
        }

        return accountFactory;
    }

    @Override
    public IAccount createAccount(Customer customer, String accNumber, String type) {
        IAccount account;
        if (type.equals("checkings"))
            account = new Checkings(customer, accNumber);

        customer.addAccount(account);
        return account;
    }
}
