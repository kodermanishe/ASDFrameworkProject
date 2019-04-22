package framework;

import framework.party.Company;
import framework.party.Person;

import java.time.LocalDate;

public class PartyFactory {

	private PartyFactory() {}
	private static PartyFactory partyFactory = null;
	
	public static PartyFactory getInstance() {
		if(partyFactory == null) {
			partyFactory = new PartyFactory();
		}
		
		return partyFactory;
	}
	
    public static Company createCompany(String name, String street, String city, String state, int zip, String email) {
        return new Company(name, street, city, state, zip, email);
    }

    public static Person createPerson(String name, String street, String city, String state, int zip, String email, LocalDate birthDay) {
        return new Person(name, street, city, state, zip, email, birthDay);
    }

}
