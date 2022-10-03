package com.cydeo.tests.day4_xpath_checkbox_findElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBox {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.id("box1"));
        System.out.println("checkbox1 =" + checkbox1.isSelected());
        checkbox1.click();
        System.out.println("checkbox1 =" + checkbox1.isSelected());
        checkbox1.click();//to uncheck the first box

        System.out.println("-------------------------------------");
        WebElement checkbox2 = driver.findElement(By.id("box2"));
        System.out.println(checkbox2.getAttribute("checked"));//the other way to verify if the checkbox checked by using getAttribute() method. getAttribute () method returns the value(string) of the selected attribute

        System.out.println("----------------------------");
        checkbox2.click();
        System.out.println(checkbox2.getAttribute("checked"));//will print null because after we uncheck the checkbox2




    }

    }


