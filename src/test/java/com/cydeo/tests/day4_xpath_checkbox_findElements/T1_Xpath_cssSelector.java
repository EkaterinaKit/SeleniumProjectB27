package com.cydeo.tests.day4_xpath_checkbox_findElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Xpath_cssSelector {
    static WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void locateXpathAndCss(){
        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using cssSelector
        //a. “Home” link by cssSelector syntax#1
        WebElement homeLink1 = driver.findElement(By.cssSelector(".nav-link"));
        //“Home” link by cssSelector syntax#2
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //"Home" link by using Xpath syntax#1
        WebElement homeLink3 = driver.findElement(By.xpath("//a[@class='nav-link']"));
        //"Home" link using xpath syntax#2
        WebElement homeLink4 = driver.findElement(By.xpath("//a[contains(@class,'nav-link')]"));



        //b. “Forgot password” header with cssSelector syntax#1
        WebElement forgotPassword1 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        //“Forgot password” header with cssSelector syntax#2
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("div.example>h2"));
        //locating "Forgot Password" with xpath locator syntax#1
        WebElement forgotPassword3 = driver.findElement(By.xpath("//div[@class='example']/h2"));
        //syntax #2
        WebElement forgotPassword4 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        //syntax#3
        WebElement forgotPassword5 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        //syntax#4
        WebElement forgotPassword6 = driver.findElement(By.xpath("//h2")); //in this case //h2 will work as well because this simple page has only one h2 type header
        //going from parent to child using xpath using syntax
        WebElement forgotPassword7 = driver.findElement(By.xpath("(//*[.='Forgot Password'])[2]"));////h2[.='Forgot Password']



        //c. “E-mail” text
        //locating with cssSelector syntax#1
        WebElement email1 = driver.findElement(By.cssSelector("label[for='email']"));
        //locating by xpath
        WebElement email2 = driver.findElement(By.cssSelector("//label[.='E-mail']"));
        //xpath using contains
        WebElement email3 = driver.findElement(By.xpath("//label[contains(@for,'email')]"));

        //d. E-mail input box
        //e. “Retrieve password” button
        //f. “Powered by Cydeo text
        //4. Verify all web elements are displayed.
    }



}
