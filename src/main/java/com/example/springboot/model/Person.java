package com.example.springboot.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 人类
 */
@Component
public class Person {

   private static Logger log = LoggerFactory.getLogger(Person.class);

    public void sayHello() {
        log.info("hello, person!");
    }

}
