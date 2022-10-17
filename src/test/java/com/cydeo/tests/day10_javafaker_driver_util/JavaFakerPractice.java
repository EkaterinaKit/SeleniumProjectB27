package com.cydeo.tests.day10_javafaker_driver_util;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    @Test
    public void java_faker_test(){
        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address() = " + faker.address().fullAddress());
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));

        System.out.println("faker.numerify(\"#####\") = " + faker.numerify("#####"));
        System.out.println("faker.letterify(\"??????\") = " + faker.letterify("??????"));
        System.out.println("faker.letterify(\"???\", true) = " + faker.letterify("???", true));
        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????", true));
        System.out.println("faker.bothify(\"###???###\") = " + faker.bothify("###???###"));
        System.out.println("faker.letterify(\"???\").toUpperCase() = " + faker.letterify("???").toUpperCase());
        System.out.println("faker.letterify(\"???????@gmail.com\") = " + faker.letterify("???????@gmail.com"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.finance().creditCard().replaceAll(\"-\",\"\") = " + faker.finance().creditCard().replaceAll("-", ""));
        System.out.println("faker.letterify(\"?????\").substring(0,1).toUpperCase() = " + faker.letterify("?").substring(0, 1).toUpperCase()+ faker.letterify("????"));
        System.out.println("faker.chuckNorris() = " + faker.chuckNorris().fact());
        System.out.println("faker.chuckNorris().fact().replaceAll(\"Chuck Norris\", \"Saim\") = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Saim"));
        System.out.println("faker.chuckNorris().fact().replace(\"Chuck Norris\", \"Katya\") = " + faker.chuckNorris().fact().replace("Chuck Norris", "Katya"));
        System.out.println("faker.finance().creditCard().replace(\"-\",\"\") = " + faker.finance().creditCard().replace("-", ""));


    }
}
