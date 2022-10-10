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

public class LinksWithoutText {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");
    }
    @Test
    public void links_without_text(){
//        3. Count the number of links that does not have text and verify
//        Expected: 109
        List<WebElement> links = new ArrayList<>(driver.findElements(By.tagName("a")));
        int count = 0;
        for (WebElement link : links) {
            if(link.getText().isEmpty()){
                count++;
            }
        }
        int actualNumberLinks = count;
        int expectedNumberLinks = 259;
        Assert.assertEquals(actualNumberLinks,expectedNumberLinks);
        //System.out.println(count);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
