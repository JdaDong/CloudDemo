package com.example.mongd.Service;

import com.example.mongd.Entity.NatureInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class NatureInfo {
    @Autowired
    private MongoTemplate mongoTemplate;

    public NatureInfoEntity getNatureInfo(){
        NatureInfoEntity natureInfoEntity = new NatureInfoEntity();
        return natureInfoEntity;
    }
}
