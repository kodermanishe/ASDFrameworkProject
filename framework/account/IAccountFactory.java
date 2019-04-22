package framework.account;

import framework.party.Customer;

public interface IAccountFactory {

     IAccount createAccount(Customer customer , int accountNumber, String accountType );
}
