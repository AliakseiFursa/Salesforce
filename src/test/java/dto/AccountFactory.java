package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount(String parentAccount, String type, String industry) {
        Faker faker = new Faker();
        return new Account(faker.name().name(), parentAccount, faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(),
                faker.internet().domainName(), type, industry, faker.number().digit(), faker.number().digit(),
                faker.leagueOfLegends().location(), faker.address().streetName(), faker.address().city(), faker.address().zipCode(),
                faker.address().state(), faker.address().country(), faker.address().streetName(), faker.address().city(),
                faker.address().zipCode(), faker.address().state(), faker.address().country());
    }
}
