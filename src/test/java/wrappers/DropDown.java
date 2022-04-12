package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown {

    WebDriver driver;
    String label;
    String type;

    public DropDown(WebDriver driver, String label, String type) {
        this.driver = driver;
        this.label = label;
        this.type = type;
    }

    public void select(String option) {
        log.info("Choosing {} in {}", option, label);
        if (type.equalsIgnoreCase("Account")) {
            driver.findElement(By.xpath(
                    String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//a", label)
            )).click();
            driver.findElement(By.cssSelector(String.format("a[title=%s]", option))).click();
        }else if (type.equalsIgnoreCase("Contact")) {
            driver.findElement(By.xpath(
                    String.format("//label[text()='%s']/..//span", label)
            )).click();
            driver.findElement(By.xpath(String.format("//span[text()='%s']", option))).click();
        }
    }
}
