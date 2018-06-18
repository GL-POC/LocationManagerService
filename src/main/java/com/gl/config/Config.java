package com.gl.config;

import com.mongodb.MongoClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

/**
 * Created by chethana.nk on 29/3/18.
 */
@EnableAutoConfiguration
@Data
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
@ComponentScan("com.gl")
public class Config {


    @Value("${database:locationsDb}")
    private String database;

    @Value("${host:127.0.0.1}")
    private String host;

    @Value("${port:9999}")
    private String port;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(getHost(), Integer.parseInt(getPort())), getDatabase());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }

}
