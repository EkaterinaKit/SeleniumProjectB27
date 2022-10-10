package com.cydeo.tests.day7_windows_webtables;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NumberOfLinksInPage {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void number_of_links_test(){
//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com
        driver.get("https://www.openxcell.com");

//        3. Count the number of the links on the page and verify
//        Expected: 332
        List<WebElement> links = new ArrayList<>(driver.findElements(By.tagName("a")));
        for (WebElement link : links) {
            System.out.println(link.getText());//printing the test of all links in teh page
        }

        int actualNumber = links.size();
        int expectedNumber = 355;
        Assert.assertEquals(actualNumber,expectedNumber);


        }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
    }


