package com.cydeo.tests.day4_xpath_checkbox_findElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/radio_buttons");
        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        System.out.println(blueRadioBtn.isSelected());
        blueRadioBtn.click();
        System.out.println(blueRadioBtn.isSelected());
        System.out.println("------------------------------------");

        WebElement redRadioBtn = driver.findElement(By.id("red"));
        redRadioBtn.click();
        System.out.println(redRadioBtn.isSelected());
        System.out.println(blueRadioBtn.isSelected());
        System.out.println("-------------------------------------");

        WebElement greenRadioBtn = driver.findElement(By.id("green"));
        System.out.println(greenRadioBtn.getAttribute("disabled"));
        System.out.println(greenRadioBtn.isEnabled());//will print false because green button is disabled

        List<WebElement> allColors = driver.findElements(By.name("color"));
        System.out.println("allColors size is = " + allColors.size());

        for( WebElement each : allColors){
            if(each.isSelected()){
                System.out.println("selected radio button is = " + each.getAttribute("id"));
            }
        }
        System.out.println("-------------------------------------");
        for (WebElement eachColor :  allColors){
            eachColor.click();
            System.out.println("eachColor is " + eachColor.isSelected());
            System.out.println("eachColor is " + eachColor.isEnabled());
        }

        driver.quit();
    }

}
