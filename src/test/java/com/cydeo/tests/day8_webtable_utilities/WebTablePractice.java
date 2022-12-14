package com.cydeo.tests.day8_webtable_utilities;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTablePractice {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

    }
    @Test
    public void order_name_verify_test(){

    //    2. Verify Bob’s name is listed as expected.
//    Expected: “Bob Martin”
        WebElement bobMartinName = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinName.getText();
        Assert.assertEquals(actualBobName,expectedBobName);


//    3. Verify Bob Martin’s order date is as expected
//    Expected: 12/31/2021
        WebElement bobMartinDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedDate = "12/31/2021";
        String actualDate = bobMartinDate.getText();
        Assert.assertEquals(actualDate,expectedDate);

    }
    @Test
    public void test2(){
        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("customerOrderDate1 " + customerOrderDate1);
    }
    @Test
    public void test3(){
        WebTableUtils.orderVerify(driver,"Ned Stark","05/12/2021");
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
