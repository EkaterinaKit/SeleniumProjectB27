package com.cydeo.tests.day4_xpath_checkbox;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

        driver.quit();
    }

}
