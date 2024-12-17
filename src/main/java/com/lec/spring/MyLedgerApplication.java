package com.lec.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyLedgerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLedgerApplication.class, args);
    }

}
