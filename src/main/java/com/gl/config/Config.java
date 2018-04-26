package com.gl.config;

import com.mongodb.MongoClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by chethana.nk on 29/3/18.
 */
@Configuration
@ComponentScan("com.gl")
@EnableMongoRepositories("com.gl.repository")
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
public class Config {


    private String db;

    private String host;

    private String port;

    public String getDb() {
        return db;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {

        return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "pmsDb");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }

}
