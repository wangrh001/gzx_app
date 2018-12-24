package com.bangnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
public class EnterpriseDigitalOfficePlatform extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EnterpriseDigitalOfficePlatform.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EnterpriseDigitalOfficePlatform.class, args);
    }
}

