package dto;

public class Contact {

    String salutation;
    String firstName;
    String lastName;
    String accountName;
    String phone;
    String description;
    String mailingStreet;

    public Contact(String salutation, String firstName, String lastName, String accountName, String phone, String description, String mailingStreet) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountName = accountName;
        this.phone = phone;
        this.description = description;
        this.mailingStreet = mailingStreet;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }
}
