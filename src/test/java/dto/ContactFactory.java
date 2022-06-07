package dto;

import com.github.javafaker.Faker;

public class ContactFactory {

    public static Contact getContact(String salutation, String accountName, String reportsTo, String leadSource,
                                     String birthdate) {
        Faker faker = new Faker();
        return new Contact(salutation, faker.name().firstName(), faker.name().lastName(), accountName, faker.name().title(),
                faker.phoneNumber().phoneNumber(), faker.phoneNumber().cellPhone(), faker.internet().emailAddress(),
                reportsTo, faker.address().streetName(), faker.address().city(), faker.address().zipCode(),
                faker.address().state(), faker.address().country(), faker.address().streetName(), faker.address().city(),
                faker.address().zipCode(), faker.address().state(), faker.address().country(), faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(),
                faker.name().fullName(), faker.commerce().department(), leadSource, birthdate,
                faker.leagueOfLegends().location());
    }
}
