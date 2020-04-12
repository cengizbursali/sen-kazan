package com.cengizbursali.senkazan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SenkazanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SenkazanApplication.class, args);
    }
}
