package banking.facade_DB;

import banking.account.BankAccountFactory;
import framework.account.IAccount;
import framework.facade_DB.Controller;
import framework.party.Customer;

import java.util.Objects;

public class BankController extends Controller {

    @Override
    public IAccount createAccount(Customer customer, String number, String type){
        IAccount account = DB.getAccount(customer, number);
        if (Objects.isNull(account)){
            account = BankAccountFactory.createAccount(customer, number, type);
        }
        return account;
    }

}
