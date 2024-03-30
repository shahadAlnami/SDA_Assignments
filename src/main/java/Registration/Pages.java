package Registration;

import engine.ActionsBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public abstract class Pages {
    final WebDriver driver;
    final ActionsBot bot;
    final Wait<WebDriver> wait;
    public Pages(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait){
        this.driver = driver;
        this.bot = bot;
        this.wait = wait;
    }
}
