package com.example.mongd.Service;

import com.example.mongd.Entity.TourismInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class TourismInfo {

    @Autowired
    private MongoTemplate mongoTemplate;

    public TourismInfoEntity getTourismInfo(){
        TourismInfoEntity tourismInfoEntity = new TourismInfoEntity();
        return tourismInfoEntity;
    }
}
