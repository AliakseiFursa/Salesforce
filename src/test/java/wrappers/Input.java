package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {

    WebDriver driver;
    String label;
    String type;

    public Input(WebDriver driver, String label, String type) {
        this.driver = driver;
        this.label = label;
        this.type = type;
    }

    public void write(String text) {
        log.info("Writing {} into {}", text, label);
        if (type.equalsIgnoreCase("Account")) {
            driver.findElement(By.xpath
                    (String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input", label)
                    )).sendKeys(text);
        }else if (type.equalsIgnoreCase("Contact")) {
            driver.findElement(By.xpath
                    (String.format("//label[text()='%s']/..//input", label)
                    )).sendKeys(text);
        }
    }

    public void writeAndClick(String text) {
        log.info("Writing {} into {}", text, label);
        driver.findElement(By.xpath(String.format("//label[text()='%s']/..//input", label))).sendKeys(text);
        driver.findElement(By.xpath(String.format("//strong[text()='%s']", text))).click();
    }
}