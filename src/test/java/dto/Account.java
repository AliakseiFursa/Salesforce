package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Account {

    String accountName;
    String website;
    String type;
    String phone;
    String fax;
    String parentAccount;
    String industry;
    String employees;
    String annualRevenue;
    String description;
}
