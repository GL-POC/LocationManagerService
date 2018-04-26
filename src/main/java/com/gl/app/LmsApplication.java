package com.gl.app;

import com.gl.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Created by chethana.nk on 29/3/18.
 */

public class LmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Config.class, args);
    }
}
