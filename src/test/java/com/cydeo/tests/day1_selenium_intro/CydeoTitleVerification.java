package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
TC #1:  Cydeo Title Verification
1. Open Chrome browser
2. Go to https://www.cydeo.com
3. Verify title:
Expected: Cydeo

 */
public class CydeoTitleVerification {
    public static void main(String[] args) {
        //setting up WebDriverManager
        WebDriverManager.chromedriver().setup();

        //opening an empty browser with creating instance of driver

        WebDriver driver = new ChromeDriver();

        //maximizing window in order not to lose any web element

        driver.manage().window().maximize();

        driver.get("https://cydeo.com");

        String expectedTitle = "Cydeo";//expected title from requirements
        String currentTitle = driver.getTitle();//getting actual title

        //checking if titles are match

        if(currentTitle.equals(expectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Verification Failed");
        }
        driver.quit();
    }
}
