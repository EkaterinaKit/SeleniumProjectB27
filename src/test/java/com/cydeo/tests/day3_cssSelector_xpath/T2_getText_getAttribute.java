package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {
        //1- Open a Chrome browser
        //2- Go to: https://login1.nextbasecrm.com/
        WebDriver driver =  WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedLabel = "Remember me on this computer";
        String actualLabel = rememberMeLabel.getText();

        if(expectedLabel.equals(actualLabel)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualText = forgotPasswordLink.getText();
        String expectedText  = "FORGOT YOUR PASSWORD?";
        if(expectedText.equals(actualText)){//can not use equalIgnoreCase because if it is meant to be in all upper case then we will ignore error (bug).
            System.out.println("Passed");
        }else{
            System.out.println("Failed");//this it is going to fail because in actual website "Forgot your password?" written in upper case letters.
        }
        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedHrefText = "forgot_password=yes";
        String actualHrefText = forgotPasswordLink.getAttribute("href");
        if(actualHrefText.contains(expectedHrefText)){
            System.out.println("Href attribute value verification passed ");
        }else{
            System.out.println("Href attribute value verification failed");
        }
        driver.quit();




    }
}
