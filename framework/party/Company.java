package framework.party;

import java.util.ArrayList;
import java.util.List;

public class Company extends AbstractCustomer implements Customer {

    private List<IPerson> employees;

    public Company(String name, String street, String city, String state, int zip, String email) {
        super(name, street, city, state, zip, email);
        
        employees = new ArrayList<>();
    }

    public void hirePerson(IPerson person) {
        employees.add(person);
    }

    public void firePerson(IPerson person) {
        employees.remove(person);
    }

    public int employeesNumber() {
        return employees.size();
    }
}
