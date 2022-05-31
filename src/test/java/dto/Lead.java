package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Lead {

    String salutation;
    String firstName;
    String lastName;
    String company;
    String title;
    String leadStatus;
    String phone;
    String email;
    String rating;
    String street;
    String city;
    String zipCode;
    String state;
    String country;
    String website;
    String numberOfEmployees;
    String annualRevenue;
    String leadSource;
    String industry;
    String description;
}
