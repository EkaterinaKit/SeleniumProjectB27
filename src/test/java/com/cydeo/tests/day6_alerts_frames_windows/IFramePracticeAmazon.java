package com.cydeo.tests.day6_alerts_frames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFramePracticeAmazon {
    //iframe practice using Amazon.com
    //1. log in to Amazon  account
    static WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }
    @Test
    public void tc001_testLoginFunction() {
        //find "Hello, sign in Accounts and Lists"
        WebElement helloBtn = driver.findElement(By.id("nav-link-accountList"));
        helloBtn.click();
        //System.out.println(helloBtn.getText());

/*
        Actions action = new Actions(driver);
        action.moveToElement(helloBtn).perform();

 */
        //make sure you are at the Amazon Log in page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon Sign-In";
        Assert.assertEquals(actualTitle,expectedTitle);

        //locate email enter box and enter email - "kitaevak@mail.com
        WebElement loginBox = driver.findElement(By.id("ap_email"));
        loginBox.sendKeys("kitaevak@mail.com");

        //click on Continue button but first locate that button and verify it is correct one by printing the text of that button
        WebElement continueBtn = driver.findElement(By.xpath("//input[@class='a-button-input']"));
        String continueBtnText = continueBtn.getText();
        String expectedText = "Continue";
        continueBtn.click();

        //enter password but first locate password box
        WebElement passwordBox = driver.findElement(By.id("ap_password"));
        passwordBox.sendKeys("Kitaeva0557");

        //click Sign in button
        WebElement signInBtn = driver.findElement(By.id("signInSubmit"));
        signInBtn.click();

    }
    @Test(dependsOnMethods = {"tc001_testLoginFunction"})
    public void tc002_testIFrameSwitch () {
        //switch to iframe (xfinity frame

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='flex-container flex-direction-row flex-nowrap flex-align-end flex-justify-space-between flex-shrink-0']")));
        //locate button "Shop now" inside the frame

        WebElement shopNowBtn = driver.findElement(By.xpath("//a[@class='button-container flex-container flex-align-center flex-justify-center']"));
        shopNowBtn.click();



    }
}
