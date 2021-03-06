package framework.facade_DB;

import framework.account.AccountFactory;
import framework.account.IAccount;
import framework.account.entry.Entry;
import framework.party.Customer;
import framework.party.CustomerFactory;
import framework.party.CustomerType;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Controller {

    protected Model DB;
    public Controller() {
        DB = Model.getInstance();
    }

    public Customer createCustomer(String name, String street, String city, String state, int zip, String email, String n){
        IAccount account = DB.getAccount(n);
        if(Objects.nonNull(account))
            return null;
        Customer company = DB.getCustomer(CustomerType.COMPANY, name);
        if (Objects.isNull(company)) {
            company = CustomerFactory.createCompany(name, street, city, state, zip, email);
            DB.addCustomer(company);
        }
        return company;
    }

    public Customer createPerson(String name, String street, String city, String state, int zip, String email, LocalDate birthDate, String n){
        IAccount account = DB.getAccount(n);
        if(Objects.nonNull(account))
            return null;
        Customer person = DB.getCustomer(CustomerType.PERSON, name);
        if (Objects.isNull(person)) {
            person = CustomerFactory.createPerson(name, street, city, state, zip, email, birthDate);
            DB.addCustomer(person);
        }
        return person;
    }

    public IAccount createAccount(Customer customer, String number, String type){
        IAccount account = DB.getAccount(customer, number);
        if (Objects.isNull(account)){
            account = AccountFactory.createAccount(customer, number, type);
        }
        return account;
    }

    public void withdraw(IAccount account, double money){
        account.addEntry(new Entry(money*(-1), LocalDate.now(), "withdraw"));
    }

    public void deposit(IAccount account, double money){
        account.addEntry(new Entry(money, LocalDate.now(), "deposit"));
    }

    public void addInterest(){
        DB.updateInterest();
    }

    public List<Customer> getCustomers(){
        return DB.getCustomers();
    }

    public List<IAccount> getAccounts(){
        return DB.getAccounts();
    }

    public IAccount getAccount(String number){
        return DB.getAccount(number);
    }

}
