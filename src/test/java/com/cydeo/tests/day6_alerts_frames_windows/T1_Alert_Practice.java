package com.cydeo.tests.day6_alerts_frames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practice {
    static WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @Test
    public void alertTask1(){
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        informationAlertBtn.click();


        //4. Click to OK button from the alert
        //to handle JS alerts we need to use Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();//accept method means clicking OK button


        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement textMessage = driver.findElement(By.id("result"));

        //Assert.assertTrue(textMessage.isDisplayed());//this code will only confirm that there is a text appeared after OK button on the alert message was pressed. but it will not show the exact text
        String actualTextMessage = textMessage.getText();
        String expectedTextMessage = "You successfully clicked an alert";

        Assert.assertEquals(actualTextMessage,expectedTextMessage);

    }
}
