package framework.party;

import java.time.LocalDate;

public class Person extends AbstractCustomer implements IPerson {

    private LocalDate birthDay;
    private Company company;

    public Person(String name, String street, String city, String state, int zip, String email, LocalDate birthDay) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.birthDay = birthDay;

    }

    @Override
    public CustomerType getType() {
        return CustomerType.PERSON;
    }

    @Override
    public LocalDate getBirthday() {
        return birthDay;
    }
}
