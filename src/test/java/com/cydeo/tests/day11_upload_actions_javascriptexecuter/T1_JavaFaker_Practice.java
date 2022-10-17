package com.cydeo.tests.day11_upload_actions_javascriptexecuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T1_JavaFaker_Practice {

        @Test
        public void registration_form(){
//        1. Open browser
//        2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

            Faker faker = new Faker();

//        3. Enter first name
            WebElement firstNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
            firstNameBox.sendKeys(faker.name().firstName());


//        4. Enter last name
            WebElement lastNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
            lastNameBox.sendKeys(faker.name().lastName());

//        5. Enter username
            WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
            usernameBox.sendKeys(faker.letterify("????????"));


//        6. Enter email address
            WebElement emailBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
            emailBox.sendKeys(faker.internet().emailAddress());


//        7. Enter password
            WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
            passwordBox.sendKeys(faker.internet().password());


//        8. Enter phone number
            WebElement phoneNumberBox = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
            phoneNumberBox.sendKeys(faker.numerify("###-###-####"));


//        9. Select a gender from radio buttons
            List<WebElement> gender = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));
                gender.get(faker.number().numberBetween(0,2)).click();//need number from 0 to 2 because indexes in List start from 0.


//        10. Enter date of birth
            WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
            dateOfBirth.sendKeys("12/09/1986");



//        11. Select Department/Office
            Select options = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
            options.selectByIndex(faker.number().numberBetween(1,9));//index 0 is already selected for default option - "department"


//        12. Select Job Title
            Select jobTitleOptions = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
            jobTitleOptions.selectByIndex(faker.number().numberBetween(1,8));


//        13. Select programming language from checkboxes
            List<WebElement> languageOptions = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
            languageOptions.get(faker.number().numberBetween(0,2)).click();



//        14. Click to sign up button
            WebElement signInBtn = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
            signInBtn.click();


//        15. Verify success message “You’ve successfully completed registration.” is
//        displayed.
            WebElement message = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
            String actualText = message.getText();
            System.out.println(actualText);

            Assert.assertEquals(actualText,"You’ve successfully completed registration.","Text do not match!");
        }
    }



