package framework;

import framework.party.Company;
import framework.party.Person;

import java.time.LocalDate;

public class CustomerFactory {

	private CustomerFactory() {}
	private static CustomerFactory partyFactory = null;
	
	public static CustomerFactory getInstance() {
		if(partyFactory == null) {
			partyFactory = new CustomerFactory();
		}
		
		return partyFactory;
	}
	
    public static Company createCompany(String name, String street, String city, String state, String zip, String email) {
        return new Company(name, street, city, state, zip, email);
    }

    public static Person createPerson(String name, String street, String city, String state, String zip, String email, LocalDate birthDay) {
        return new Person(name, street, city, state, zip, email, birthDay);
    }

}