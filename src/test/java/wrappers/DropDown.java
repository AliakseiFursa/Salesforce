package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class DropDown {

    WebDriver driver;
    String label;
    String objectType;

    public DropDown(WebDriver driver, String label, String objectType) {
        this.driver = driver;
        this.label = label;
        this.objectType = objectType;
    }

    public void selectValue(String option) {
        log.info("Choosing {} in {}", option, label);
        if (objectType.equalsIgnoreCase("Account")) {
            WebElement element = driver.findElement(By.xpath(
                    String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//a", label)));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            driver.findElement(By.cssSelector(String.format("a[title=%s]", option))).click();
        }else if (objectType.equalsIgnoreCase("Contact")) {
            driver.findElement(By.xpath(
                    String.format("//label[text()='%s']/..//span", label))).click();
            driver.findElement(By.xpath(String.format("//span[@title='%s']", option))).click();
        }else if (objectType.equalsIgnoreCase("Lead")) {
            driver.findElement(By.xpath(
                    String.format("//label[text()='%s']/..//span", label))).click();
            driver.findElement(By.xpath(String.format("//span[@title='%s']", option))).click();
        }
    }

    public void selectActionOnListPage(String option) {
        driver.findElement(By.xpath(String.format("//a[text()='%s']/ancestor::tr//a[@role='button']", label))).click();
        driver.findElement(By.xpath(String.format("//div[contains(@class, 'branding-actions')]//a[@title='%s']", option))).click();
    }

    public void selectActionOnEntityPage(String option) {
        WebElement element = driver.findElement(By.xpath("//span[text()='Show more actions']//ancestor::button"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        driver.findElement(By.xpath(String.format("//a[@name='%s']", option))).click();
    }
}

