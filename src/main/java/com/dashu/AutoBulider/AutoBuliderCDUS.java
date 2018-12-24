package com.dashu.AutoBulider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
public class AutoBuliderCDUS extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AutoBuliderCDUS.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AutoBuliderCDUS.class, args);
    }
}

