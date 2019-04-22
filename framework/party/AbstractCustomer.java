package framework.party;

import framework.account.IAccount;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCustomer implements ICompany {

    private String name;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;

    private List<IAccount> accounts = new ArrayList<>();

    protected AbstractCustomer(String name, String street, String city, String state, int zip, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getEmail() {
        return email;
    }

    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    public void removeAccount(IAccount account) {
        accounts.remove(account);
    }

    public void notifyOwner() {
        System.err.println("Message sent to the owner: " + name);
    }
    
    public List<IAccount> getAccounts(){
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
