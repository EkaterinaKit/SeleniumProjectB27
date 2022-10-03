package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    static WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //set up browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void googleTitleVerification(){

        //2. navigate to Google page
       driver.get("https://www.google.com");
       //3. Verify if title is "Google"
       String actualTitle =  driver.getTitle();
       String expectedTitle = "Google";

        Assert.assertEquals(actualTitle, expectedTitle,"Title is not matching");//it is optional to put message

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
