package edu.eci.spti.logsAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "edu.eci.spti.logs" })
public class LogsAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogsAPIApplication.class, args);
    }
}
