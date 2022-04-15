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
    String phone;
    String description;
    String mailingStreet;
}
