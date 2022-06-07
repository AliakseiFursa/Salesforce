package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Account {

    String accountName;
    String parentAccount;
    String phone;
    String fax;
    String website;
    String type;
    String industry;
    String employees;
    String annualRevenue;
    String description;
    String billingStreet;
    String billingCity;
    String billingZipCode;
    String billingState;
    String billingCountry;
    String shippingStreet;
    String shippingCity;
    String shippingZipCode;
    String shippingState;
    String shippingCountry;
}
