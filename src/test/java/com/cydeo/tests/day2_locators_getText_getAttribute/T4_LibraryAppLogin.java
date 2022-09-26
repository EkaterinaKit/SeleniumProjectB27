package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
5. Verify: visually “Sorry, Wrong Email or Password”
displayed
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
 */
public class T4_LibraryAppLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Chrome browser
        //2. Go to https://library2.cydeo.com/login.html
        driver.navigate().to("https://library2.cydeo.com/login.html");

        //3. Enter username: “incorrect@email.com”

        WebElement usernameInput = driver.findElement(By.className("form-control"));//here can locate by className because className will appear first for the userName input box. It will find first match because className locator is not unique
        usernameInput.sendKeys("incorrect@email.com");

        //4. Enter password: “incorrect password”
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));//here we need to look by id because if we use className it will not be going to be unique one
        passwordInput.sendKeys("incorrect password");
        //passwordInput.sendKeys("incorrect password" + Keys.ENTER);could do that as well because usually after user put username and password click Enter key. But we located sign in button, so we can check if button also works

        //5. Click to Sign in button
        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();






    }
}
