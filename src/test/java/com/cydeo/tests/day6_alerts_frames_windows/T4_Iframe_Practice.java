package com.cydeo.tests.day6_alerts_frames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Iframe_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make set up
        //3. Go to: https://practice.cydeo.com/iframe
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
    }
    @Test
    public void iframeTask(){

//        4. Assert: “Your content goes here.” Text is displayed.
       driver.switchTo().frame(0);//switching to iframe using index 0 in this task because there is only one frame in the HTML code
        //switching to iframe using id value
        //driver.switchTo().frame("mce_0_ifr");

        //switch to iframe using iframe locator
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        WebElement textInFrame = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(textInFrame.isDisplayed());

//        5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        //need to switch back to parent(main) frame first

        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        WebElement headerText = driver.findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertTrue(headerText.isDisplayed());
    }
}
