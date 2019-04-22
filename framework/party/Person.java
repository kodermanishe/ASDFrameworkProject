package framework.party;

import java.time.LocalDate;

public class Person extends AbstractCustomer implements IPerson {

    public Person(String name, String street, String city, String state, int zip, String email, LocalDate birthDay) {
        super(name, street, city, state, zip, email);
        this.birthDay = birthDay;
    }

    private LocalDate birthDay;
    private Company company;

}
