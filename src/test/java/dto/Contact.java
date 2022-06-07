package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Contact {

    String salutation;
    String firstName;
    String lastName;
    String accountName;
    String title;
    String phone;
    String mobile;
    String email;
    String reportsTo;
    String mailingStreet;
    String mailingCity;
    String mailingZipCode;
    String mailingState;
    String mailingCountry;
    String otherStreet;
    String otherCity;
    String otherZipCode;
    String otherState;
    String otherCountry;
    String fax;
    String homePhone;
    String otherPhone;
    String asstPhone;
    String assistant;
    String department;
    String leadSource;
    String birthdate;
    String description;
}
