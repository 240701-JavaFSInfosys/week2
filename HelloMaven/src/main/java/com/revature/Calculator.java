package com.revature;

public class Calculator {

    /* A better calculator would have more than just add and divide of course
    But this demo is mainly for examples of:

     1) Unit Testing with JUnit
     2) Logging with Logback */

    public int add(int a, int b){
        return a + b;
    }

    public int divide(int a, int b){

        if(b == 0){
            throw new IllegalArgumentException("User tried to divide by zero... get a load of this guy hahahahahah");
        }
        return a / b;

    }

}
