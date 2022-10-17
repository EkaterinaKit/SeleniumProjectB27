package com.cydeo.tests.day10_javafaker_driver_util;

public class Singleton {

    //create private constructor
    private Singleton(){}

    //create private static String
    //prevent access and provide a getter method

    private static String word;

    //this utility method will return the word the way we want it to return
    public static String getWord(){

        if(word==null){
            System.out.println("First time call. Word object is null. Assigning value now");
            word="Something";
        }else{
            System.out.println("Word already has value");
        }
        return word;
    }

}
