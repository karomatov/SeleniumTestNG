package tests.VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.VyTrackTestBase;
import utils.Wait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task extends VyTrackTestBase {


    @Test(description = "Verify that view, edit adn delete option are available, more complex one  ")
    public void test(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 2);
        Wait.seconds(3);
        Driver.get().findElement(By.linkText("Activities")).click();
        Driver.get().findElement(By.linkText("Calendar Events")).click();
        Actions actions = new Actions(Driver.get());
        //actions.moveToElement().perform();
//        actions.moveToElement().perform();
        Wait.seconds(2);
        System.out.println(Driver.get().getTitle());

        List<WebElement> table = Driver.get().findElements(By.xpath("//table//td[2]"));
        List<WebElement> options = new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getText().equals("Testers Meeting")){
                options.add(Driver.get().findElement(By.xpath("//table//tr[" +i+"]//td[9]")));
            }

        }



    }
    @Test(description = "Verify that view, edit adn delete option are available,")
    public void test1(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 2);
        Wait.seconds(3);
        Driver.get().findElement(By.linkText("Activities")).click();
        Driver.get().findElement(By.linkText("Calendar Events")).click();
        Actions actions = new Actions(Driver.get());

        Wait.seconds(2);// your wait class might be different

        WebElement el = Driver.get().findElement(By.xpath("//table//tr[15]//td[9]"));
        actions.moveToElement(el).perform();
        wait.until(ExpectedConditions.visibilityOfAllElements(Driver.get().findElements(By.xpath("//li[@class='launcher-item']//a"))));
        List<WebElement> actual = Driver.get().findElements(By.xpath("//li[@class='launcher-item']//a"));
        List<String> expected = Arrays.asList("View", "Edit", "Delete");

        for (int i = 0; i< actual.size(); i++){
            Assert.assertEquals(actual.get(i).getAttribute("title"), expected.get(i), "Options are not matching");
            System.out.println("Expected: " + expected.get(i) + " Actual: " + actual.get(i).getAttribute("title"));
        }


    }

    @Test(description = "Verify that Title column still displayed")
    public void test2(){
        Wait.seconds(5);
        Driver.get().findElement(By.linkText("Activities")).click();
        Driver.get().findElement(By.linkText("Calendar Events")).click();
        Wait.seconds(2);
        Driver.get().findElement(By.xpath("//div[@class='column-manager dropdown']")).click();
        //Driver.get().findElement(By.xpath("//div[@class='column-manager-actions']//a")).click();
        List<WebElement> uncheck = Driver.get().findElements(By.xpath("//tr[@class='renderable']"));

        for (WebElement each : uncheck ) {
            System.out.println(each.getText());
        }


    }





}
