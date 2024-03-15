package test.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Week5_Task7 extends Tests{

    @Test
    public void DoubleClickTest(){
        Actions actions=new Actions(driver);

        //Go to URL: https://api.jquery.com/dblclick/
        bot.navigate("https://api.jquery.com/dblclick/");

        //Double click on the blue square at the bottom of the page and then write the changed color.
        By dblClickElement= By.tagName("iframe");
        driver.switchTo().frame(driver.findElement(dblClickElement));
        By blueColouredButton= By.cssSelector("body>div");
        JavascriptExecutor jsexecutor1= (JavascriptExecutor) driver;
        jsexecutor1.executeScript("arguments[0].scrollIntoView();", driver.findElement(blueColouredButton));
        actions.doubleClick(driver.findElement(blueColouredButton)).perform();
        String color=  driver.findElement(blueColouredButton).getCssValue("background-color");
        System.out.println("color = " + color);


        //Go top of the page and sendKeys "Thanks to JavascriptExecutor"
        driver.switchTo().defaultContent();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        By searchBar= By.xpath("//input[@type='search']");
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(searchBar));
        bot.type(searchBar,"Thanks to JavascriptExecutor");


        //Go to the bottom of the page and click the book, name"jQuery in Action"
        By jsInActionImg=By.xpath("//a[@href='https://www.manning.com/books/jquery-in-action-third-edition']");
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(jsInActionImg));
        bot.click(jsInActionImg);
        String currentURL= driver.getCurrentUrl();
        Assertions.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition", currentURL);
    }
}
