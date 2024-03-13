package test.junit;

import org.apache.logging.log4j.core.appender.SyslogAppender;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class Week5_Task4 extends Tests{
      /**
       * Go to URL: http://facebook.com
       * getCookies,
       * addCookie,
       * deleteCookieNamed,
       * deleteAllCookies
     */

      @Test
    public void cookies(){
          bot.navigate("http://facebook.com");
          prettyPrint();
          driver.manage().addCookie(new Cookie("First Name","Shahad"));
          driver.manage().addCookie(new Cookie("Last Name","Alnami"));
          driver.manage().addCookie(new Cookie("Job","QA Automation Test Engineer"));
          prettyPrint();
          driver.manage().deleteCookieNamed("_js_datr");
          prettyPrint();
          driver.manage().deleteAllCookies();
          prettyPrint();
      }

      public void prettyPrint(){
          System.out.println("Cookies size: "+ driver.manage().getCookies().size());
          System.out.println("Cookies List");
          driver.manage().getCookies().forEach(System.out::println);
          System.out.println("-----------------------------------------------------------");
      }
}
