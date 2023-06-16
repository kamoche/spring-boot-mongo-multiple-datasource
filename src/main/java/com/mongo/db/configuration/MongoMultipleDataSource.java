package com.mongo.db.configuration;

import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoMultipleDataSource {
    @Autowired
    private Environment environment;

    @Bean
    public MongoDbFactory ussdSessionDbFactory(){
        return new SimpleMongoDbFactory(new MongoClientURI(environment.getProperty("spring.data.mongo.ussd_session_count.uri")));
    }

    @Bean
    public MongoTemplate ussdSessionTemplate(){
        return new MongoTemplate(ussdSessionDbFactory());
    }


    @Bean
    public MongoDbFactory ussdPopularDbFactory(){
        return new SimpleMongoDbFactory(new MongoClientURI(environment.getProperty("spring.data.mongo.ussd_popular_menu.uri")));
    }

    @Bean
    public MongoTemplate ussdPopularTemplate(){
        return new MongoTemplate(ussdPopularDbFactory());
    }



}
