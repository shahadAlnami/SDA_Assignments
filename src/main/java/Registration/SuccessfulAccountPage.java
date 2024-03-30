package Registration;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulAccountPage extends Pages {


    private final By successAccountCreationMessage = By.tagName("h1");
    private final By continueButtonInTheSuccessAccountCreation = By.linkText("Continue");


    public SuccessfulAccountPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver,bot,wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAccountCreationMessage));
    }

    @Step("Then I will create an account successfully")
    public String successfulCreationOfTheAccountMessage(){
       return bot.getText(successAccountCreationMessage);
    }

    @Step("And I will press continue")
    public AccountPage pressContinueButton(){
        bot.click(continueButtonInTheSuccessAccountCreation);
        return new AccountPage(driver,bot,wait);
    }


}
