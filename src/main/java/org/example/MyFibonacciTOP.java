package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "com.example")
public class MyFibonacciTOP {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MyFibonacciTOP.class)
                .run(args);
    }
}
