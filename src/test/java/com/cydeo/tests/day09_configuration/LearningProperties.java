package com.cydeo.tests.day09_configuration;

import org.testng.annotations.Test;

public class LearningProperties {
    @Test
    public void java_properties_read_text(){
        //key = value
        //getProperty("key")-->value
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.version"));

    }
}
