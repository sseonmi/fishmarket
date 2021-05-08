package com.test.fishmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.test.fishmarket.dto")
public class FishmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(FishmarketApplication.class, args);
    }

}
