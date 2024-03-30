package Registration;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class AccountPage extends Pages{

    private final By accountPageText = By.xpath("(//li[contains(@class,'active')])");

    public AccountPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver,bot,wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPageText));
    }

    @Step("So I can be directed to my Account page")
    public String successfulRedirectionToTheAccountPage(){
        return bot.getText(accountPageText);
    }
}
