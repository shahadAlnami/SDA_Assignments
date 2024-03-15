package test.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Week5_Task3 extends Tests{
    /**
     * Go to Amazon
     * Scroll to the bottom of the page using a robot
     * Click on the "Back to top" web element
     * Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
     * Use Actions to type "ClarusWay" in the search box and perform the search
*/
    @Test
    public void amazonSearchTest() throws InterruptedException, AWTException {
        bot.navigate("https://www.amazon.com");

        // Scroll to the bottom of the page using a robot
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_END);
//        robot.keyRelease(KeyEvent.VK_END);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Click on the "Back to top" web element
        By backToTopButton = By.className("navFooterBackToTopText");
        bot.click(backToTopButton);

        // Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
        By amazonLogo = By.xpath("//a[contains(@href,'/?ref_=footer_logo')]");
        js.executeScript("arguments[0].click();", driver.findElement(amazonLogo));

        // Use Actions to type "ClarusWay" in the search box and perform the search
        By searchBox = By.id("twotabsearchtextbox");
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(searchBox), "ClarusWay").sendKeys(Keys.ENTER).build().perform();

    }
}
