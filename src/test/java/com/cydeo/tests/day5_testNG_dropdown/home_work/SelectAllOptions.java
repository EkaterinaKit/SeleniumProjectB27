package com.cydeo.tests.day5_testNG_dropdown.home_work;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectAllOptions {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

//        3. Select all the options from multiple select dropdown.
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select option = new Select(dropDown);
        option.selectByIndex(0);
        option.selectByValue("js");
        option.selectByVisibleText("C#");
        option.selectByIndex(3);
        option.selectByValue("ruby");
        option.selectByVisibleText("C");

//        4. Print out all selected values.
        List<WebElement> list = new ArrayList<>(option.getAllSelectedOptions());
        for(WebElement each : list){
            System.out.println(each.getAttribute("value"));
        }
//        5. Deselect all values.
        option.deselectAll();
        driver.quit();
    }
}
