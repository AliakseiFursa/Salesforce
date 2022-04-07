package tests;

import dto.Account;
import dto.Contact;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;
import steps.AccountSteps;
import steps.ContactSteps;
import steps.LoginSteps;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    SalesNavigationMenuBarPage salesNavigationMenuBarPage;
    NewAccountModal newAccountModal;
    NewContactModal newContactModal;
    AccountsListPage accountsListPage;
    AccountPage accountPage;
    ContactsListPage contactsListPage;
    ContactPage contactPage;
    Account account;
    Contact contact;
    AccountSteps accountSteps;
    ContactSteps contactSteps;
    LoginSteps loginSteps;

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening Browser")
    public void setUp(/*String browser, ITestContext testContext*/) {
/*        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(false);
            driver = new FirefoxDriver(options);
        }*/
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
//        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        salesNavigationMenuBarPage = new SalesNavigationMenuBarPage(driver);
        newAccountModal = new NewAccountModal(driver);
        newContactModal = new NewContactModal(driver);
        accountsListPage = new AccountsListPage(driver);
        accountPage = new AccountPage(driver);
        contactsListPage = new ContactsListPage(driver);
        contactPage = new ContactPage(driver);
        account = new Account("TeachMeSkills", "teachmeskills.by", "Analyst", "256789121",
                "256789122", "Father", "Apparel", "5", "100000", "Hello");
        contact = new Contact("Mr.", "Al", "Fur", "TeachMeSkills", "2235616",
                "Good boy", "Minsk");
        accountSteps = new AccountSteps(driver);
        contactSteps = new ContactSteps(driver);
        loginSteps = new LoginSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        driver.quit();
    }
}
