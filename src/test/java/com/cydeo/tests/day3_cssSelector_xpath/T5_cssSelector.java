package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_cssSelector {
    public static void main(String[] args) {
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement passwordBox = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        passwordBox.sendKeys("hello@gmail.com" + Keys.ENTER);


        //4- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        WebElement errorText = driver.findElement(By.cssSelector("div[class='errortext']"));
        String actualErrorText = errorText.getText();
        String expectedErrorText = "Login or E-mail not found";
        if(expectedErrorText.equals(actualErrorText)){
            System.out.println("Verification test Passed");
        }else{
            System.out.println("Verification test Failed");
        }

        //5- Click to `Reset password` button
        WebElement resetPassBtn = driver.findElement(By.cssSelector(".login-btn"));
        resetPassBtn.click();




        //PS: Inspect and decide which locator you should be using to locate web elementsPS2:
        // Pay attention to where to get the text of this button from
    }
}
