package com.songyuankun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author songyuankun
 */
@SpringCloudApplication
@EnableFeignClients
public class MediaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaClientApplication.class, args);
    }

}
