package com.example.mongd;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.util.HashMap;


@RestController
public class CreateDocController {
    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/create")
    public Mono<Void> create(){
//        MongoClient mongoClient = new MongoClient("192.168.1.8", 27017);
//        MongoDatabase test0001 = mongoClient.getDatabase("test0001");
//        test0001.createCollection("catlikeAnimals");
//        MongoCollection<Document> catlikeAnimals = test0001.getCollection("catlikeAnimals");
//        HashMap<String, Object> map1 = new HashMap<>();
//        map1.put("name", "cat");
//        map1.put("weight", 12.0);
//        map1.put("height", 21.1);
//        Document document = new Document(map1);
//        document.append("speed", 30);
//        catlikeAnimals.insertOne(document);

        MongoCollection<Document> catlikeAnimals = mongoTemplate.createCollection("catlikeAnimals");
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("name", "cat");
        map1.put("weight", 12.0);
        map1.put("height", 21.1);
        Document doc1 = new Document(map1);
        catlikeAnimals.insertOne(doc1);
        return  Mono.just(null);
    }

}
