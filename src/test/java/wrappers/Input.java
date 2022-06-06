package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {

    WebDriver driver;
    String label;
    String objectType;

    public Input(WebDriver driver, String label, String objectType) {
        this.driver = driver;
        this.label = label;
        this.objectType = objectType;
    }

    public void write(String text) {
        log.info("Writing {} into {}", text, label);
        if (objectType.equalsIgnoreCase("Account")) {
            driver.findElement(By.xpath
                    (String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input", label)
                    )).clear();
            driver.findElement(By.xpath
                    (String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input", label)
                    )).sendKeys(text);
        } else if (objectType.equalsIgnoreCase("Contact")) {
            driver.findElement(By.xpath
                    (String.format("//label[text()='%s']/..//input", label))).clear();
            driver.findElement(By.xpath
                    (String.format("//label[text()='%s']/..//input", label))).sendKeys(text);
        } else if (objectType.equalsIgnoreCase("Lead")) {
            driver.findElement(By.xpath
                    (String.format("//label[text()='%s']/..//input", label))).clear();
            driver.findElement(By.xpath
                    (String.format("//label[text()='%s']/..//input", label))).sendKeys(text);
        }
    }

    public void writeAndClick(String text) {
        log.info("Writing {} into {}", text, label);
        driver.findElement(By.xpath(String.format("//label[text()='%s']/..//input", label))).sendKeys(text);
        driver.findElement(By.xpath(String.format("//strong[text()='%s']", text))).click();
    }
}