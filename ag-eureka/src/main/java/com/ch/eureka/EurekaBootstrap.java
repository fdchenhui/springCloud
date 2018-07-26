package com.ch.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2018/7/26.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(EurekaBootstrap.class,args);
    }
}
