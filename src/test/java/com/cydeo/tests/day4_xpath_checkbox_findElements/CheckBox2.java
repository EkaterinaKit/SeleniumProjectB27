package com.cydeo.tests.day4_xpath_checkbox_findElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBox2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        1. Go to http://practice.cydeo.com/checkboxes
        driver.get("https://practice.cydeo.com/checkboxes");

//        2. Confirm checkbox #1 is NOT selected by default
        WebElement box1 = driver.findElement(By.id("box1"));
        System.out.println(box1.isSelected());//will print false because checkbox1 is not selected

//        3. Confirm checkbox #2 is SELECTED by default.
        WebElement box2 = driver.findElement(By.id("box2"));
        System.out.println(box2.isSelected());//will print true because checkbox2 is selected by default

//        4. Click checkbox #1 to select it.
        box1.click();

//        5. Click checkbox #2 to deselect it.
        box2.click();

//        6. Confirm checkbox #1 is SELECTED.
        System.out.println(box1.isSelected());//will print true because we selected checkbox1 in line 27

//        7. Confirm checkbox #2 is NOT selected.
        System.out.println(box2.isSelected());//will print false and by printing it confirms that checkbox2 is not selected because we unchecked it in line 30



    }
}
