package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(By.xpath(String.format("//label[text()='%s']/..//input", label))).sendKeys(text);
        driver.findElement(By.xpath(String.format("//strong[text()='%s']", text))).click();
    }
}