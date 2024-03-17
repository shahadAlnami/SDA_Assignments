package test.testng;

import engine.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Week6_Task1 extends Tests{

    @Test
    public void testGoToFacebook() {
        // Go to Facebook
        bot.navigate("https://www.facebook.com");
    }

    @Test(dependsOnMethods = "testGoToFacebook")
    public void testGoToGoogle() {
        // Go to Google
        bot.navigate("https://www.google.com");
    }

    @Test(dependsOnMethods = "testGoToGoogle")
    public void testGoToAmazon() {
        // Go to Amazon
        bot.navigate("https://www.amazon.com");
    }
}
