package tests.testng;

import Registration.AccountPage;
import Registration.RegistrationFormPage;
import Registration.SuccessfulAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Week7_Task1 extends Tests{
    /* go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
       register account test with fluent page object approach
     */
    @Test
    public void POMRegisterTest(){

        String successfulCreationOfTheAccount =  new RegistrationFormPage(driver,bot,wait)
                .goTo()
                .registerNewAccount("Shahad","shahad","shahad","9661234567","Password1234567","Password1234567")
                .successfulCreationOfTheAccountMessage();
        Assert.assertTrue(successfulCreationOfTheAccount.contains("Has Been Created!"));
        String redirectedToTheAccountPage = new SuccessfulAccountPage(driver,bot,wait).pressContinueButton().successfulRedirectionToTheAccountPage();
        Assert.assertEquals(redirectedToTheAccountPage,"Account");

    }
}

