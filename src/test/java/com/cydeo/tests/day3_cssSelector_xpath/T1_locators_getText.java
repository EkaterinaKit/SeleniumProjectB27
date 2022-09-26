package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {
    public static void main(String[] args) {
        //1- Open a Chrome browser
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        //4- Enter incorrect password: “incorrect”
        //5- Click to log in button.
        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        loginBox.sendKeys("incorrect");
        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("incorrect");
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();


        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorText = driver.findElement(By.className("errortext"));

        String actualErrorText = errorText.getText();
        String expectedErrorText = "Incorrect login or password";
        if(expectedErrorText.equals(actualErrorText)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.quit();


    }
}
