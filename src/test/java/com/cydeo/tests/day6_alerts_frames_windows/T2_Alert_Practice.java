package com.cydeo.tests.day6_alerts_frames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_Alert_Practice {
    static WebDriver driver;
    @BeforeMethod
    public void setUpMethod () {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }
    @Test(enabled = false)
        public void confirmationAlert() {

    //click on "Click for JS Confirm"
    WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
    button.click();

    //verify you get the confirmation alert(confirmation alert usually has two buttons)
    Alert alert = driver.switchTo().alert();
    alert.dismiss();

    //find the text that pups up after you dismissed the alert. Expected "You clicked: Cancel"
        WebElement text = driver.findElement(By.id("result"));

        String actualText = text.getText();
        String expectedText = "You clicked: Cancel";
        Assert.assertEquals(actualText,expectedText);

}
@Test
public void promptAlert(){
        //click on JS Prompt
    WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
    button.click();

    //verify you get the prompt alert
    Alert alert = driver.switchTo().alert();
    alert.sendKeys("OK!");//Chrome browser does not allow to enter message but if message still sent(line 48) and then alert accepted the message that was entered is printed. If you do dismiss() method the "null" will be printed
    alert.accept();

    //verify the message. Expected message is what has been sent(line 48). Expected: "You entered: OK!"
    String alertText = driver.findElement(By.id("result")).getText();
    String expectedText = "You entered: OK!";

    Assert.assertEquals(alertText,expectedText);

}
@AfterMethod
    public void tearDownMethod(){
        driver.quit();

}
}
