package framework.party;

import framework.account.IAccount;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCustomer implements Customer {

    protected String name;
    protected String street;
    protected String city;
    protected String state;
    protected int zip;
    protected String email;

    private List<IAccount> accounts = new ArrayList<>();

    @Override
    public int getCountEmp() {
        return accounts.size();
    }

    @Override
    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void removeAccount(IAccount account) {
        accounts.remove(account);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public int getZip() {
        return zip;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void SendEmailToCustomer() {
        System.out.println("Sending message to customer: " + name);
    }

    @Override
    public List<IAccount> getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IAccount)) {
            return false;
        }
        AbstractCustomer party = (AbstractCustomer) o;
        if (this.name.equals(party.name) &&
        this.street.equals(party.street) &&
        this.city.equals(party.city) &&
        this.state.equals(party.state) &&
        this.zip == party.zip &&
        this.email.equals(party.email)) {return true;}
        else return false;
    }
}
