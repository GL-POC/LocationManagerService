package com.gl.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
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
import org.xmlpull.v1.XmlPullParserException;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

/**
 * Created by chethana.nk on 29/3/18.
 */
@Configuration
@ComponentScan("com.gl")
@EnableMongoRepositories("com.gl.repository")
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class Config {


    @Value("${spring.data.mongodb.database:locationsDb}")
    private String db;

    @Value("${spring.data.mongodb.host:127.0.0.1}")
    private String host;

    @Value("${spring.data.mongodb.port:9999}")
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

        return new SimpleMongoDbFactory(new MongoClient(getHost(), Integer.parseInt(getPort())), getDb());
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }

    @Bean
    public Docket api() throws IOException, XmlPullParserException {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gl.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfo("Location management Service Api Documentation", "Documentation automatically generated", "1.1", null, new Contact("chethana", "localhost", "chethana.nk@globallogic.com"), null, null));

    }

}
