package com.example.mongd.Service;

import com.example.mongd.Entity.HumanityInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class HumanityInfo {
    @Autowired
    private MongoTemplate mongoTemplate;

    public HumanityInfoEntity getHumanityInfo(){
        HumanityInfoEntity humanityInfoEntity = new HumanityInfoEntity();
        return humanityInfoEntity;
    }
}
