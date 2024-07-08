package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    /* A better calculator would have more than just add and divide of course
    But this demo is mainly for examples of:

     1) Unit Testing with JUnit
     2) Logging with Logback */

    //to use logback, we need to instantiate a Logger object
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public int add(int a, int b){
        log.info("Adding {} and {}", a, b);
        return a + b;
    }

    public int divide(int a, int b){

        if(b == 0){
            log.warn("Hey heads up, some bozo is about to try dividing by zero lol");
            throw new IllegalArgumentException("User tried to divide by zero... get a load of this guy hahahahahah");
        }

        log.info("Dividing {} by {}", a, b);
        return a / b;

    }

}
