package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_RadioButton {
    public static void main(String[] args) throws InterruptedException{
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyButton.click();

        //4. Verify “Hockey” radio button is selected after clicking.
        if(hockeyButton.isSelected()){
            System.out.println("Hockey Button is selected");
        }else{
            System.out.println("Hockey Button is not selected");
        }

        //Test all radio buttons if they are all work(if they are clickable)

        List<WebElement> sportRadioButtons = driver.findElements(By.xpath("//input[@name='sport']"));
        for (WebElement each : sportRadioButtons) {//going through all the sport radio buttons
            each.click();//clicking all sport radio buttons to check if they are clickable
            if(each.isSelected()){
                System.out.println(each.getAttribute("id")+ "Radio button is selected");//getText() will not work in this case because getText() only works if there is a text
            }
            Thread.sleep(3000);// do not need it teh code but for the better visual representation of web browser go from one button to another button
            }
        driver.quit();

        }

    }


