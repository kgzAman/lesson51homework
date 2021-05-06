package com.aman.edu.homew51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class Homew51Application {

    public static void main(String[] args) {
        SpringApplication.run(Homew51Application.class, args);
    }

}
