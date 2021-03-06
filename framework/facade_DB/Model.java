package framework.facade_DB;

import framework.account.IAccount;
import framework.party.Customer;
import framework.party.CustomerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Model {

    List<Customer> customers;
    private static Model instance;

    private Model() {
        customers = new ArrayList<>();
    }

    public static Model getInstance() {
        if(instance == null) {
            instance = new Model();
        }

        return instance;
    }

    public void updateInterest(){
        customers.stream().flatMap(c -> c.getAccounts().stream())
                .forEach(a -> a.addInterest());
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }

    public Customer getCustomer(CustomerType type, String name){
        Optional<Customer> optional = customers.stream()
                .filter(c -> c.getType() == type && c.getName().equals(name))
                .findAny();

        if (optional.isPresent())
            return optional.get();

        return null;
    }

    public List<Customer> getCustomers(){
        return customers;
    }


    public List<IAccount> getAccounts(){
        return customers.stream().flatMap(c -> c.getAccounts().stream()).collect(Collectors.toList());
    }

    public IAccount getAccount(Customer customer, String accNumber){
        Optional<IAccount> optional = customer.getAccounts().stream()
                .filter(acc -> acc.getAccNumber().equals(accNumber))
                .findAny();

        if (optional.isPresent())
            return optional.get();

        return null;
    }

    public IAccount getAccount(String accNumber){
        Optional<IAccount> optional = customers.stream()
                .flatMap(c -> c.getAccounts().stream())
                .filter(acc -> acc.getAccNumber().equals(accNumber))
                .findAny();

        if (optional.isPresent())
            return optional.get();

        return null;
    }

}
