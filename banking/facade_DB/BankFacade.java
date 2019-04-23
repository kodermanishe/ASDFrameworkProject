package banking.facade_DB;

import banking.account.BankAccountFactory;
import framework.account.IAccount;
import framework.facade_DB.Facade;
import framework.party.Customer;

import java.util.Objects;

public class BankFacade extends Facade {

    @Override
    public IAccount createAccount(Customer customer, String number, String type){
        IAccount account = DB.getAccount(customer, number);
        if (Objects.isNull(account)){
            account = BankAccountFactory.getInstance().createAccount(customer, number, type);
        }
        return account;
    }

}
