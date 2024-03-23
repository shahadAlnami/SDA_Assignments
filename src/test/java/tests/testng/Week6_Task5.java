package tests.testng;

import engine.CustomListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Week6_Task5 extends Tests{
    /**
     * Go to URL: http://crossbrowsertesting.github.io/
     * Click to To-Do App
     * Checking Box to do-4 and Checking Box to do-5
     * If both clicks worked, then the following List should be have length 3.
     * Assert that this is correct
     * Assert that the to do we added is present in the list
     * Archiving old todos
     * If our archive link worked, then the following list should have length 4.
     * Assert that this is true as well
     * Doing Cross Browser Testing.
     */


    @Test
    public void task6(){
        bot.navigate("http://crossbrowsertesting.github.io/");

        By toDoLink = By.linkText("To-Do App");
        bot.click(toDoLink);

        By toDo4 = By.name("todo-4");
        bot.click(toDo4);

        By toDo5 = By.name("todo-5");
        bot.click(toDo5);

        By todoList = By.className("ng-binding");
        Assert.assertTrue(driver.findElement(todoList).getText().startsWith("3"));


        By addToDoThingFeild = By.id("todotext");
        bot.type(addToDoThingFeild,"Practice Selenium More");

        By addButton = By.id("addbutton");
        bot.click(addButton);

        By theAddThing = By.xpath("//span[contains(text(),'Practice')]");
        Assert.assertEquals(driver.findElement(theAddThing).getText(),"Practice Selenium More");

        By archiveLink = By.linkText("archive");
        bot.click(archiveLink);

        Assert.assertTrue(driver.findElement(todoList).getText().startsWith("4"));

    }
}
