package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");//google.com will be open

        driver.navigate().to("https://tesla.com");//tesla website will be open

        Thread.sleep(5000);//after Tesla page is open the compiler will wait 5 seconds and navigate back to Google.com. Used Thread.sleep() to make compiler wait few second just to see how code works

        driver.navigate().back();//going back to Google

        Thread.sleep(5000);//will waite for 5 seconds

        driver.navigate().forward();//will go back to Tesla

        driver.navigate().refresh();//refresh teh Tesla page

        //driver.close();//close current window

        driver.navigate().to("https://amazon.com");

        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        driver.quit();



    }
}
