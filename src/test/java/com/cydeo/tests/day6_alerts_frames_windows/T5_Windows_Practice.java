package com.cydeo.tests.day6_alerts_frames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {
    static WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //    1. Create a new class called: T5_WindowsPractice
       //    2. Create new test and make set up
      //    3. Go to : https://practice.cydeo.com/windows
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void windowsTask(){
        String currentWindow = driver.getWindowHandle();
        //    4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Before opening new window " + actualTitle);

       //    5. Click to: “Click Here” link
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereBtn.click();

      //    6. Switch to new Window.
        for (String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow=" + eachWindow);
            System.out.println("Driver.getTitle()=" + driver.getTitle());
        }
     //    7. Assert: Title is “New Window”
        actualTitle = driver.getTitle();
        String expectedTitleAfterClick = "New Window";

        Assert.assertEquals(actualTitle,expectedTitleAfterClick);

        //if you want to come back to original window at the end of teh task
        driver.switchTo().window(currentWindow);

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
