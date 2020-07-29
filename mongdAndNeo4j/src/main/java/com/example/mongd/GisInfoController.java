package com.example.mongd;

import com.example.mongd.Service.GisInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/GisInfo")
@RestController
public class GisInfoController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/queryGisInfoByCity")
    public String queryGisInfoByCity(String cityName){
        Query query = new Query(Criteria.where("cityName").is(cityName));
        GisInfo gisInfo = mongoTemplate.findOne(query, GisInfo.class, "gisIngo");
        return gisInfo.getGisInfo();
    }

    @RequestMapping("/queryTravelExpenseAvgByLongitudeRange")
    public List<String> queryGisInfoByLongitudeRange(int minLongitude, int maxLongitude){
        Criteria criteria = Criteria.where("longitude").gte(minLongitude).lte(maxLongitude);
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(criteria),
                 Aggregation.group("longitude").avg("travelExpense").as("travelExpenseAvg"));
        AggregationResults<GisInfo> gisInfoAggregationResults = mongoTemplate.aggregate(aggregation, "gisInfo", GisInfo.class);
        List<GisInfo> mappedResults = gisInfoAggregationResults.getMappedResults();
        List<String> gisInfos = mappedResults.stream().map(x->x.getGisInfo()).collect(Collectors.toList());
        return gisInfos;
    }

    @RequestMapping("/updateGisInfoByCity")
    public String updateGisInfoByCity(String cityName){
        Query query = new Query(Criteria.where("cityName").is(cityName));
//        Sort.Order humanityInfoOrder = new Sort.Order(Sort.Direction.ASC, "humanityInfo");
//        Sort.Order natureInfoOrder = new Sort.Order(Sort.Direction.DESC, "natureInfo");
//        ArrayList<Sort.Order> sorts = new ArrayList<>();
//        sorts.add(humanityInfoOrder);
//        sorts.add(natureInfoOrder);
        Aggregation.newAggregation();
        GisInfo gisInfo = mongoTemplate.findOne(query, GisInfo.class);
        Update update = new Update();
        //update.set("humanityInfo", )
//
//        RestTemplate restTemplate = new RestTemplate();
//        List<ServiceInstance> hystrix = discoveryClient.getInstances("hystrix");
//        restTemplate.exchange("", HttpMethod.GET, null, )

        return gisInfo.getGisInfo();
    }
}
