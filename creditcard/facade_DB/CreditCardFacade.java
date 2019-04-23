package creditcard.facade_DB;

import creditcard.account.CreditCardAccountFactory;
import framework.account.IAccount;
import framework.facade_DB.Facade;
import framework.party.Customer;

import java.time.LocalDate;
import java.util.Objects;

public class CreditCardFacade extends Facade {

    @Override
    public IAccount createAccount(Customer customer, String number, String type){
        IAccount account = DB.getAccount(customer, number);
        if (Objects.isNull(account)){
            account = CreditCardAccountFactory.getInstance().createAccount(customer, number, type);
        }
        return account;
    }

    public IAccount createAccount(Customer customer, String number,  String date, String type){
        IAccount account = DB.getAccount(customer, number);
        if (Objects.isNull(account)){
            account = CreditCardAccountFactory.getInstance().createAccount(customer, number,date, type);
        }
        return account;
    }

}
