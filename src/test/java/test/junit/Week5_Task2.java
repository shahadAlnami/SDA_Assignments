package test.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Week5_Task2 extends Tests{
    /** ( This task should be managed with keyboard actions )
     * go to https://www.google.com/
     * search for "Scroll Methods" by using an Actions object
     * */

    @Test
    public void searchWithTheActionClass(){
        bot.navigate("https://www.google.com/");
        By searchBox = By.id("APjFqb");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(searchBox))
                .sendKeys("Scroll Methods")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }
}
