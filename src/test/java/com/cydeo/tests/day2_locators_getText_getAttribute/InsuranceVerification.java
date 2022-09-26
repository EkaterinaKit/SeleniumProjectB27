package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsuranceVerification {
    /*
    1. Open Chrome browser
2. Go to
https://www.qa1.excelsoirinsurance.com/login
3. Verify URL contains
     Expected: "excelsoirinsurance"
4. Verify title:
       Expected: "Login | Excelsoir Insurance"
day2_locators_getText_getAttribute
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();//driver here represents your browser

        driver.manage().window().maximize();

        driver.get("https://www.qa1.excelsoirinsurance.com/login");
        String currentTitle = driver.getTitle();
        String expectedTitle = "Login | Excelsoir Insurance";

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "excelsoirinsurance";

        if (currentUrl.contains(expectedUrl)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        if(currentTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("PASSED");
        }
        driver.quit();
    }
}
