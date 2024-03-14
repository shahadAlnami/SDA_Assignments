package test.junit;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;

import java.io.File;
import java.nio.file.Paths;

public class Week5_Task6 extends Tests {
    @Test
    public void AmazonScreenshot() throws IOException{
        // Go to amazon.com
        bot.navigate("https://www.amazon.com/");
        driver.manage().window().maximize();

        // Take Full Page Screenshot
        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(fullPageScreenshot.toPath(), new File("/Users/shahadalshareef/Desktop/fullpage.png").toPath());

        // Take specific WebElement Screenshot
        By specificElement = By.className("navFooterBackToTopText");
        File elementScreenshot = driver.findElement(specificElement).getScreenshotAs(OutputType.FILE);
        Files.copy(elementScreenshot.toPath(), new File("/Users/shahadalshareef/Desktop/element.png").toPath());

    }
}
