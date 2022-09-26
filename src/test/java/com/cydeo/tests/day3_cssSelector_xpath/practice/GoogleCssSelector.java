package com.cydeo.tests.day3_cssSelector_xpath.practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCssSelector {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //1.go to https://Google.com
        //make sure you are on the Google page. Expected Google
        driver.get("https://Google.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if(expectedTitle.equals(actualTitle)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        //2. search for Etsy
        WebElement searchBox = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
        searchBox.sendKeys("etsy" + Keys.ENTER);

        //3. on Google result page find result numbers
        //4. print the text
        WebElement resultStats = driver.findElement(By.cssSelector("div[id='result-stats']"));
        System.out.println(resultStats.getText());

        //go back to Google
        driver.navigate().to("https://Google.com");
        WebElement googleSearch = driver.findElement(By.cssSelector("div[class='FPdoLc lJ9FBc']>center>input[class='gNO89b']"));
        googleSearch.click();

        //find element Settings on Google home page

        WebElement settings = driver.findElement(By.cssSelector("div[class='rIbAWc']>div[class='ayzqOc pHiOh']"));
        settings.click();
        driver.quit();
    }
}
