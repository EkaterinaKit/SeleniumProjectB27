package com.cydeo.tests.day09_configuration;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T1_CRM_Login extends TestBase {
    @Test
    public void crm_login_test(){
//        1. Create new test and make set ups
//        2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

//        3. Enter valid username hr2@cydeo.com
        WebElement inputUserName = driver.findElement(By.xpath
                ("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("hr2@cydeo.com");

//        4. Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

//        5. Click to Log In button
        WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInBtn.click();

//        6. Verify title is as expected:
//        Expected: Portal
        //Assert.assertEquals(driver.getTitle(),"Portal");

        BrowserUtils.verifyTitle(driver,"Portal");

}

@Test
    public void crm_login_test_2(){
        driver.get("http://login1.nextbasecrm.com/");
    CRM_Utilities.login_crm(driver);
    BrowserUtils.verifyTitle(driver,"Portal");
}
@Test
    public void crm_login_test_3(){
        driver.get("http://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver,"hr3@cydeo.com","UserUser");
        BrowserUtils.sleep(4);
        BrowserUtils.verifyTitle(driver,"Portal");//will not pass because page title is different
}
}
