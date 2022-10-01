package com.cydeo.tests.day5_testNG_dropdown.home_work;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectState {
    static WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test

    // 2. Go to https://practice.cybertekschool.com/dropdown
    public void selectState(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        //4. Select Virginia
        //5. Select California

        stateDropDown.selectByVisibleText("Illinois");
        stateDropDown.selectByVisibleText("Virginia");
        stateDropDown.selectByVisibleText("California");

        stateDropDown.selectByValue("CA");
        stateDropDown.selectByIndex(5);

        //6. Verify final selected option is California. Use all Select options. (visible text, value, index)

        String actualText = stateDropDown.getFirstSelectedOption().getText();
        String expectedText = "California";
        Assert.assertEquals(actualText,expectedText);

    }
    @AfterMethod
    public void tierDownMethod(){
        driver.quit();
    }

}
