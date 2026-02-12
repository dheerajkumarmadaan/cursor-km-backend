package com.ttn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {
    public static void main(String[] args) {
        String str = null;
        if (str == null) {
            str.toLowerCase();
        }
        System.out.println(str);
        SpringApplication.run(TodoApplication.class, args);
    }
} 