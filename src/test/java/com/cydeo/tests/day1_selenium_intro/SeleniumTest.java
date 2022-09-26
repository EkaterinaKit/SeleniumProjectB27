package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        //setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        //create instance of this chrome driver

        WebDriver driver = new ChromeDriver();

        //testing if driver is working
        driver.get("https://google.com");
    }

}
