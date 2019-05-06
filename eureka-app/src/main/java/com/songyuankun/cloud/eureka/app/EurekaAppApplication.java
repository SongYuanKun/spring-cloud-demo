package com.songyuankun.cloud.eureka.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * eureka客户端
 *
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaAppApplication.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
