package com.cydeo.tests.day1_selenium_intro.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to
https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
       Expected: Practice
 */
public class TitleUrl {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://practice.cydeo.com");

        String partString = "cydeo";

        String currentUrl = driver.getCurrentUrl();

        //verifying if current URL contains word "cydeo"

        if(currentUrl.contains("cydeo")){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        //verifying title of teh current page

        String expectedTitle = "Practice";
        String currentTitle = driver.getTitle();

        if(currentTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.quit();
    }
}
