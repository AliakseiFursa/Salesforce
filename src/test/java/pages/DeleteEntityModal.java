package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DeleteEntityModal extends BasePage {

    public static final By DELETE_BUTTON = By.xpath("//div[contains(@class, 'modal-container')]//span[text()='Delete']");

    public DeleteEntityModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Step("Confirm account deletion")
    public void confirmDeletion() {
        log.info("Confirming deletion");
        driver.findElement(DELETE_BUTTON).click();
    }
}
