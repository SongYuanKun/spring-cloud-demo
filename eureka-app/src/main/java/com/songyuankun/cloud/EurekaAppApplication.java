package com.songyuankun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * eureka客户端
 *
 * @author songyuankun
 */
@SpringCloudApplication
@EnableFeignClients
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
