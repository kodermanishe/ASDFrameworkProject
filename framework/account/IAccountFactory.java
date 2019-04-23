package framework.account;

import framework.party.Customer;

public interface IAccountFactory {

     IAccount createAccount(Customer customer , String accountNumber, String accountType );
}
