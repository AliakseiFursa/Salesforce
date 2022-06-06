package dto;

import com.github.javafaker.Faker;

public class LeadFactory {

    public static Lead getLead(String salutation, String leadStatus, String rating,
                               String leadSource, String industry) {
        Faker faker = new Faker();
        return new Lead(salutation, faker.name().firstName(), faker.name().lastName(), faker.company().name(), faker.name().title(),
                leadStatus, faker.phoneNumber().phoneNumber(), faker.internet().emailAddress(), rating,
                faker.address().streetName(), faker.address().city(), faker.address().zipCode(),
                faker.address().state(), faker.address().country(), faker.internet().domainName(), faker.number().digit(),
                faker.number().digit(), leadSource, industry, faker.leagueOfLegends().location());
    }
}
