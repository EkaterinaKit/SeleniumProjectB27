package com.cydeo.tests.day11_upload_actions_javascriptexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_Text {

    @Test
    public void guru99_upload_text() {
        //  1. Go to  “http://demo.guru99.com/test/upload”
        Driver.getDriver().get("https://demo.guru99.com/test/upload");

//  2. Upload file into Choose File
        WebElement choseFileBtn = Driver.getDriver().findElement(By.xpath("//input[@id='uploadfile_0']"));
        choseFileBtn.sendKeys("/Users/ekaterinakitaeva/Downloads/some-file.txt");


//3. Click terms of service check box
        WebElement termsCheckBox = Driver.getDriver().findElement(By.xpath("//input[@id='terms']"));
        termsCheckBox.click();

//4. Click Submit File button
        WebElement submitBtn = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitBtn.click();

//5. Verify expected message appeared. Expected:
//  “1 file
//    has been successfully uploaded.”
        WebElement confirmationText = Driver.getDriver().findElement(By.id("res"));
        String expectedText = "1 file\nhas been successfully uploaded.";
        String actualText = confirmationText.getText();
        Assert.assertEquals(actualText,expectedText,"Text do not match");

    }

}
