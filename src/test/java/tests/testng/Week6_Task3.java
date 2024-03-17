package tests.testng;

import engine.CustomListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListener.class)

public class Week6_Task3 extends Tests{
    /**
     * go to "https://practicetestautomation.com/practice-test-login/"
     * enter username - "student"
     * enter password - "incorrectPassword"
     * and login
     * SOFT ASSERT the error message shown
     * SOFT ASSERT
     * the error message is "Your password is invalid!" */

    @Test(testName = "Basic Soft Assertions Test", description = "Given I am on the practice login page, When I input valid credentials, Then I am logged in successfully.")
    public void softAssertionsTest() {
        bot.navigate("https://practicetestautomation.com/practice-test-login/");
        By usernameInput = By.id("username");
        By passwordInput = By.id("password");
        By submitButton = By.id("submit");

        bot.type(usernameInput,"student");
        bot.type(passwordInput,"incorrectPassword");
        bot.click(submitButton);

       By errorMessage= By.id("error");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(errorMessage).isDisplayed());
        softAssert.assertEquals(driver.findElement(errorMessage).getText(),"Your password is invalid!");
        softAssert.assertAll();

    }

}
