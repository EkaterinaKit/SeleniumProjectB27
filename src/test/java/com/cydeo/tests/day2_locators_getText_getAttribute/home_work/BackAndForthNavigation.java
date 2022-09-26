package com.cydeo.tests.day2_locators_getText_getAttribute.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForthNavigation {
    public static void main(String[] args) {
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");

        //3- Click to Gmail from top right.
        //4- Verify title contains:
        //Expected: Gmail
        WebElement link = driver.findElement(By.linkText("Gmail"));
        link.click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google
        expectedTitle = "Google";
        actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
