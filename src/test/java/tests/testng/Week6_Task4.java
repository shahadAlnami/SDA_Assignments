package tests.testng;

import engine.CustomListener;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Week6_Task4 extends Tests{
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search filed for ( do it with Data Provider) Mac, iPad and Samsung.

    @Test(dataProvider = "searchKeywords", testName = "Login and Serch in a website" , description = "Log in to the site and Search for Mac, iPad and Samsung using Data Provider")
    public void performSearch(String searchKeywords) {
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        By emailInputFiled = By.id("input-email");
        By passwordInputFiled = By.id("input-password");
        By loginButton = By.xpath("//input[@type='submit']");
        bot.type(emailInputFiled,"clarusway@gmail.com");
        bot.type(passwordInputFiled,"123456789");
        bot.click(loginButton);

        Assert.assertEquals(driver.getCurrentUrl(),"https://opencart.abstracta.us/index.php?route=account/account");

        By searchFiled = By.name("search");
        bot.type(searchFiled,searchKeywords);
        driver.findElement(searchFiled).sendKeys(Keys.ENTER);
    }

    @DataProvider(name = "searchKeywords")
    public Object[][] searchKeywordsDataProvider() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }

}
