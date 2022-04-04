package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    SalesNavigationMenuPage salesNavigationMenuPage;
    NewAccountModal newAccountModal;
    NewContactModal newContactModal;
    AccountsPage accountsPage;
    AccountPage accountPage;
    ContactsPage contactsPage;
    ContactPage contactPage;

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
        salesNavigationMenuPage = new SalesNavigationMenuPage(driver);
        newAccountModal = new NewAccountModal(driver);
        newContactModal = new NewContactModal(driver);
        accountsPage = new AccountsPage(driver);
        accountPage = new AccountPage(driver);
        contactsPage = new ContactsPage(driver);
        contactPage = new ContactPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        driver.quit();
    }
}
