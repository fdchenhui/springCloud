package com.ch.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2018/7/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class UserCenterBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterBootstrap.class,args);
    }
}
