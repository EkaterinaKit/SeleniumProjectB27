package com.cydeo.tests.day5_testNG_dropdown.home_work;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectFromNonSelect {
    static WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //        1. Open Chrome browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void selectFromNonSelect(){
//        2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown  ");
//        3. Click to non-select dropdown
        WebElement dropDown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        dropDown.click();


//        4. Select Facebook from dropdown

        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
        facebook.click();
//        5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();

    }
}
