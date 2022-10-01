package com.cydeo.tests.day5_testNG_dropdown.home_work;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDate {
    static WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void selectDate(){

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Select “December 1st, 1923” and verify it is selected. Select year using   : visible text. Select month using    : value attribute Select. Select using : index number
        Select yearDropDown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropDown.selectByVisibleText("1923");
       Select monthDropDown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
       monthDropDown.selectByValue("11");
       Select dayDropDown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
       dayDropDown.selectByIndex(0);


    }
    @AfterMethod
    public void tierDownMethod(){
        //driver.quit();
    }
}
