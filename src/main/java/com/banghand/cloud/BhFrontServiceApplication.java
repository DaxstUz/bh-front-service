package com.banghand.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.banghand.cloud.user.client","com.banghand.cloud.contentservice.client"})
@ServletComponentScan
public class BhFrontServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BhFrontServiceApplication.class, args);
    }

}
