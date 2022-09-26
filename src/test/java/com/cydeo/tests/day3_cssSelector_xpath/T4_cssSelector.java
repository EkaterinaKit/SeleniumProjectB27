package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector {
    public static void main(String[] args) {
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password

        WebElement resetButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
        String expectedResetBtnText = "Reset password";
        String actualResetBtnText = resetButton.getText();//can use getText() here because <button> is paired tag

        if(actualResetBtnText.equals(expectedResetBtnText)){
            System.out.println("Verification test passed");
        }else{
            System.out.println("Verification test failed");
        }
        driver.quit();

    }
}
