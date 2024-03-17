package test.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Week5_Task1 extends Tests{
    /**
     * Go to URL: http://demo.guru99.com/test/drag_drop.html
     * Drag and drop the BANK button to the Account section in DEBIT SIDE
     * Drag and drop the SALES button to the Account section in CREDIT SIDE
     * Drag and drop the 5000 button to the Amount section in DEBIT SIDE
     * Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
     * Verify the visibility of Perfect text.
     * */


    @Test
    public void dragAndDropBankButton(){
        // * Go to URL: http://demo.guru99.com/test/drag_drop.html
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");

        // * Drag and drop the BANK button to the Account section in DEBIT SIDE
        By bankButton = By.id("credit2");
        By polaceHolder1 = By.xpath("(//li[@class='placeholder'])[1]");
        DrageAndDrop(bankButton,polaceHolder1);

        // * Drag and drop the SALES button to the Account section in CREDIT SIDE
        By salesButton = By.id("credit1");
        By polaceHolder2 = By.xpath("(//li[@class='placeholder'])[2]");
        DrageAndDrop(salesButton,polaceHolder2);

        // * Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        By Add5000Button = By.xpath("(//li[@id='fourth'])[1]");
        By polaceHolder3 = By.xpath("(//li[@class='placeholder'])[1]");
        DrageAndDrop(Add5000Button,polaceHolder3);

        // * Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        By Add5000Button2 =  By.xpath("(//li[@data-id='2'])[2]");
        By polaceHolder4 = By.xpath("(//li[@class='placeholder'])[1]");
        DrageAndDrop(Add5000Button2,polaceHolder4);

        By text = By.xpath("(//a[@class='button button-green'])[1]");
        Assertions.assertEquals("Perfect!",driver.findElement(text).getText());
    }



    public void DrageAndDrop(By button , By polaceHolder){
        new Actions(driver)
                .clickAndHold(wait.until(f -> driver.findElement(button)))
                .pause(Duration.ofMillis(500))
                .moveToElement(wait.until(f -> driver.findElement(polaceHolder)))
                .pause(Duration.ofMillis(500))
                .release()
                .perform();
    }
}
