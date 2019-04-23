package creditcard.facade_DB;

import creditcard.account.CreditCardAccountFactory;
import framework.account.IAccount;
import framework.facade_DB.Controller;
import framework.party.Customer;

import java.util.Objects;

public class CreditCardController extends Controller {

    @Override
    public IAccount createAccount(Customer customer, String number, String type){
        IAccount account = DB.getAccount(customer, number);
        if (Objects.isNull(account)){
            account = CreditCardAccountFactory.createAccount(customer, number, type);
        }
        return account;
    }

    public IAccount createAccount(Customer customer, String number,  String date, String type){
        IAccount account = DB.getAccount(customer, number);
        if (Objects.isNull(account)){
            account = CreditCardAccountFactory.createAccount(customer, number,date, type);
        }
        return account;
    }

}
