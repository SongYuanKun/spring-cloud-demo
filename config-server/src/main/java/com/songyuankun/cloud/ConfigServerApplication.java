package com.songyuankun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * cloud-config的服务端
 *
 * @author Administrator
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@RestController
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

    /**
     * GitHub在配置webHooks的时候会发送一段json，这段json不是标准json无法解析
     * 用这个接口重新请求actuator/bus-refresh更新配置文件
     */
    @PostMapping("/refresh")
    public void refresh() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, httpHeaders);
        restTemplate.postForEntity("http://localhost:8001/actuator/bus-refresh", request, String.class);
    }

}
