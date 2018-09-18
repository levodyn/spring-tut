package com.stef.treehouse;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class AppConfig {
    public static void main(String[] Args) {
        SpringApplication.run(AppConfig.class,Args);
    }
}
