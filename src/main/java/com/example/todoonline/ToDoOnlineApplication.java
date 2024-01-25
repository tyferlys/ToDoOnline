package com.example.todoonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class ToDoOnlineApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToDoOnlineApplication.class, args);
    }
}

// TODO сделать JWT