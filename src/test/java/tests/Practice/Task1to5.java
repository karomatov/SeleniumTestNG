package tests.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;
import utils.Wait;

import java.util.List;

public class Task1to5 extends TestBase {
    @Test(description = "Verify that warning message is displayed for 'DOB' ")
    public void test1(){
        Driver.get().findElement(By.name("birthday")).sendKeys("3");
        Wait.seconds(2);
        String expected = "The date of birth is not valid";
        String actual = Driver.get().findElement(By.xpath("//small[@data-bv-for='birthday'][2]")).getText();
        Assert.assertEquals(actual,expected, "Message is not displayed");
        System.out.println(actual);
    }

    @Test(description = "Verify that C++, Java, JavaScript are as option")
    public void test2(){
        String [] expected = {"C++", "Java", "JavaScript"};
        List<WebElement> actual =  Driver.get().findElements(By.xpath("//label[@class='form-check-label']"));
        for (int i = 0; i<actual.size(); i++){
            Assert.assertEquals(actual.get(i).getText(),expected[i]);
            System.out.println("Expected: " + expected[i] + " Actual: "+ actual.get(i).getText());
        }

    }

    @Test(description = "Verify that warning message is displayed for 'First Name'")
    public void test3(){
        Driver.get().findElement(By.name("firstname")).sendKeys("3");
        Wait.seconds(2);
        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = Driver.get().findElement(By.xpath("//small[@data-bv-for='firstname'][2]")).getText();
        Assert.assertEquals(actual,expected, "Message is not displayed");
        System.out.println("Actual: " + actual);
    }

    @Test(description = "Verify that warning message is displayed for 'Last Name'")
    public void test4(){
        Driver.get().findElement(By.name("lastname")).sendKeys("3");
        Wait.seconds(2);
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = Driver.get().findElement(By.xpath("//small[@data-bv-for='lastname'][2]")).getText();
        Assert.assertEquals(actual,expected, "Message is not displayed");
        System.out.println("Actual: " + actual);
    }

    @Test(description = "Verify that registration completed message si displayed")
    public void test5(){
        Driver.get().findElement(By.name("firstname")).sendKeys("John");
        Driver.get().findElement(By.name("lastname")).sendKeys("Doe");
        Driver.get().findElement(By.name("username")).sendKeys("JohnDoe");
        Driver.get().findElement(By.name("email")).sendKeys("johndoe@gmail.com");
        Driver.get().findElement(By.name("password")).sendKeys("TheSecret");
        Driver.get().findElement(By.name("phone")).sendKeys("212-121-1212");
        Driver.get().findElement(By.xpath("//input[@value='male']")).click();
        Driver.get().findElement(By.name("birthday")).sendKeys("12/12/2012");
        WebElement dropdown = Driver.get().findElement(By.name("department"));
        Select dep = new Select(dropdown);
        dep.selectByIndex(2);
        WebElement drop = Driver.get().findElement(By.name("job_title"));
        Select job = new Select(drop);
        job.selectByIndex(4);
        Driver.get().findElement(By.xpath("//*[@value='java']")).click();
        Driver.get().findElement(By.xpath("//*[@type='submit']")).click();
        Wait.seconds(3);
        String expected = "You've successfully completed registration!";
        String actual = Driver.get().findElement(By.xpath("//div[@class='alert alert-success']//p")).getText();

        Assert.assertEquals(actual,expected, "Messages are not matching");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }



}
