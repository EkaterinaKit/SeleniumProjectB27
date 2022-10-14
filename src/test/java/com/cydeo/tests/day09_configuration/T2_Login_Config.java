package com.cydeo.tests.day09_configuration;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class T2_Login_Config extends TestBase {
    @Test

    public void testing_login(){

        driver.get(ConfigurationReader.getProperty("env"));
        BrowserUtils.sleep(4);

        CRM_Utilities.login_crm(driver,ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

        BrowserUtils.verifyTitle(driver, "Portal");

    }
}
