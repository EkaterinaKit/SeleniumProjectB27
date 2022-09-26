package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_LinkTextPractice {
    public static void main(String[] args) throws InterruptedException{
        //opening Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        Thread.sleep(3000);

        //Below example shows how to use linkText to locate hyper text
        //Click to A/B Testing from top of the list
        //WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        //abTestLink.click();

        //here is looking for teh same link but using partialLinkText method
        WebElement abTestLink = driver.findElement(By.partialLinkText("A/B"));
        abTestLink.click();



        //Verify title is: Expected: No A/B Test

        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        //go back to home page by using back()

        Thread.sleep(3000);
        driver.navigate().back();

        //verify title: Expected: Practice
        expectedTitle = "Practice";
        actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        driver.quit();
    }
}
