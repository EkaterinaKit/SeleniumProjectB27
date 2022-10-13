package com.cydeo.tests.day09_configuration;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_file_test() throws IOException {

        //1. first create an object of Properties class
        //we need properties class in order to use methods that come from that class
        Properties properties  = new Properties();

        //2. second create an object of FileInputStream
        //we need this object to open file as a stream in Java memory
        FileInputStream file = new FileInputStream("configuration.properties");


        //3. third is to load properties object using FileInputStream object
        //load "properties" object with the "file" we opened using FileInputStream
        properties.load(file);
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
    }
}