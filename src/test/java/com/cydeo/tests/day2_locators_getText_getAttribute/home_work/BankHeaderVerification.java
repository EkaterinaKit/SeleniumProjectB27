package com.cydeo.tests.day2_locators_getText_getAttribute.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankHeaderVerification {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://zero.webappsecurity.com/login.html
        driver.get("https://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        WebElement header = driver.findElement(By.className("page-header"));
        String actualText = header.getText();
        String expectedText = "Log in to ZeroBank";

        if(expectedText.equals(actualText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        System.out.println("Expected Header= " + expectedText + "|" + "Actual header= " + actualText);
        driver.quit();
    }
}
