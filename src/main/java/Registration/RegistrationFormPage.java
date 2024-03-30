package Registration;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class RegistrationFormPage extends Pages{
    private final By firstNameInput = By.id("input-firstname") ;
    private final By lastNameInput = By.id("input-lastname") ;
    private final By emailInput = By.id("input-email");
    private final By telephoneInput = By.id("input-telephone");
    private final  By passwordInput = By.id("input-password");
    private final By passwordConfirmInput = By.id("input-confirm");
    private final By privacyPolicyCheckbox = By.id("input-agree");
    private final By continueButton = By.xpath("//input[@type='submit']");

    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";


    public RegistrationFormPage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
        super(driver,bot,wait);
    }

    @Step("Given I am on the Registration Form")
    public RegistrationFormPage goTo () {
        bot.navigate(url);
        return this;
    }

    @Step("When I enter all of my information")
    public SuccessfulAccountPage registerNewAccount(String Firstname, String lastName , String emailName , String phone , String password , String confirmPassword){
        bot.type(firstNameInput,Firstname);
        bot.type(lastNameInput, lastName);
        var email =  emailName+ System.currentTimeMillis() + "@gmail.com";
        bot.type(emailInput,email);
        bot.type(telephoneInput,phone);
        bot.type(passwordInput,password);
        bot.type(passwordConfirmInput,confirmPassword);
        bot.click(privacyPolicyCheckbox);
        bot.click(continueButton);
        return new SuccessfulAccountPage(driver,bot,wait);
    }
}
