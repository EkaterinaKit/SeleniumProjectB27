package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    //Method #1 info:
    //• Name: login_crm()
    //• Return type: void
    //• Arg1: WebDriver driver
    public static void login_crm(WebDriver driver){
        //3. Enter valid username hr2@cydeo.com
        WebElement inputUserName = driver.findElement(By.xpath
                ("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("hr2@cydeo.com");

//        4. Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

//        5. Click to Log In button
        WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInBtn.click();



    }
    //Method #2 info:
    //• Name: login_crm()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String username
    //• Arg3: String password
    public static void login_crm(WebDriver driver,String username,String password){

//3. Enter valid username hr2@cydeo.com
        WebElement inputUserName = driver.findElement(By.xpath
                ("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys(username);

//        4. Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys(password);

//        5. Click to Log In button
        WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInBtn.click();

    }


}
