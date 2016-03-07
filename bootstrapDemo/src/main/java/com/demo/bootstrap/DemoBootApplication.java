package com.demo.bootstrap;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class DemoBootApplication {
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(DemoBootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
