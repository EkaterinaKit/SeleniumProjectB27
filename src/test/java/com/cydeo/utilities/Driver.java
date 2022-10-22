package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //creating private constructor, so we are eliminating access to the object of this class from other classes
    private Driver(){}

    //making our driver instance private, so it is not reachable from other classes. We make it static we want it ti run before everything else. Also, we will use in static method
    private static WebDriver driver;


    //create reusable utility method which will return same driver when we need it
    public static WebDriver getDriver(){
        if(driver==null){
            String browserType = ConfigurationReader.getProperty("browser");
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        //same driver instance will be return everytime we call Driver.getDriver() method
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();//this line will kill the session.
            driver = null;
        }
    }
}
