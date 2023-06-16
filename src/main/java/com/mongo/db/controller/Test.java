package com.mongo.db.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
public class Test {
    @Autowired
    @Qualifier(value = "ussdSessionTemplate")
    MongoTemplate ussdSession;

    @Autowired
    @Qualifier(value = "ussdPopularTemplate")
    MongoTemplate ussdPopular;

    @GetMapping("/insertPopular")
    public void insertPopular(){
        Date day_date = new Date();
        String day = new SimpleDateFormat("dd/MMM/yyyy").format(day_date);
        String time = new SimpleDateFormat("HH:mm:ss.SSS").format(day_date);
        Document canvas = new Document("date", day)
                .append("time", time)
                .append("menu", "OS_ESOCCER");
      ussdPopular.insert(canvas,day);
    }

    @GetMapping("/insertSession")
    public void insertSession(){
        Date day_date = new Date();
        String day = new SimpleDateFormat("dd/MMM/yyyy").format(day_date);
        String time = new SimpleDateFormat("HH:mm:ss.SSS").format(day_date);
        Random random = new Random();

        for(int i=0;i < 10; i++){
            int oper = random.nextInt((5 - 1) + 1) + 1;
            Document canvas = new Document("date", day)
                    .append("time", time)
                    .append("msisdn", "2547266462**")
                    .append("session_id", "")
                    .append("imsi", "imsi")
                    .append("operator", oper)
                    .append("oper_id", oper)
                    .append("account_status", "account_status");
            ussdSession.insert(canvas, day);
        }


    }
}