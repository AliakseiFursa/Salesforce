package dto;

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

    public Account(String accountName, String website, String type, String phone, String fax, String parentAccount, String industry, String employees, String annualRevenue, String description) {
        this.accountName = accountName;
        this.website = website;
        this.type = type;
        this.phone = phone;
        this.fax = fax;
        this.parentAccount = parentAccount;
        this.industry = industry;
        this.employees = employees;
        this.annualRevenue = annualRevenue;
        this.description = description;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
