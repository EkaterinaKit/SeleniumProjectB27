package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getText_cssLocator {
    public static void main(String[] args) {
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com");
        //Locating element using cssSelector by type attribute

        WebElement logInButton = driver.findElement(By.cssSelector("input[type='submit']"));

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In

        //if there is self-closing tag you can not use getText() method to find the text of teh button. In this case use getAttribute() method and then find teh text

        String actualLoginBtnText = logInButton.getAttribute("value");
        String expectedLoginBtnText = "Log In";

        if(actualLoginBtnText.equals(expectedLoginBtnText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }


    }
}
