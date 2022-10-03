package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropDown {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://amazon.com");

        //find the dropdown element in the amazon page


        Select option = new Select(driver.findElement(By.id("searchDropdownBox")));

        //select Book options using three different methods
        //option.selectByVisibleText("Alexa Skills");
        option.selectByValue("search-alias=alexa-skills");
        //option.selectByIndex(1);


        //print all the options from amazon dropdown
        List<WebElement> allOptions = option.getOptions();
        for(WebElement each : allOptions){
            System.out.println(each.getText());
        }
        System.out.println(option.isMultiple());

        WebElement first = option.getFirstSelectedOption();
        String firstName = first.getText();
        System.out.println(firstName);

        option.selectByValue("search-alias=mobile");

    }
}
