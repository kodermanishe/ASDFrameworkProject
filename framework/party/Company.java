package framework.party;

import java.util.ArrayList;
import java.util.List;

public class Company extends AbstractCustomer implements Customer {

    private List<IPerson> employees;

    public Company(String name, String street, String city, String state, int zip, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;;
        
        employees = new ArrayList<>();
    }


    @Override
    public int getCountEmp() {
        return employees.size();
    }

    @Override
    public CustomerType getType() {
        return CustomerType.COMPANY;
    }
}
