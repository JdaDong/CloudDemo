package com.example.springelk;


import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ESConfiguration {

    @Value("${spring.elasticsearch.host}")
    private String host;
    @Value("${spring.elasticsearch.port}")
    private String port;
    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestClientBuilder  restClientBuilder =
                RestClient.builder(new HttpHost(host, Integer.parseInt(port), "http"));
        restClientBuilder.setFailureListener(new RestClient.FailureListener());
        return new RestHighLevelClient(restClientBuilder);
    }

//    @Bean
//    public BulkProcessor bulkProcessor(){
//        restClient =
//                RestClient.builder(new HttpHost(host, Integer.parseInt(port))).build();
//        return  BulkProcessor.builder(restClient, new BulkProcessor.Listener() {
//            @Override
//            public void beforeBulk(long l, BulkRequest bulkRequest) {
//
//            }
//
//            @Override
//            public void afterBulk(long l, BulkRequest bulkRequest, BulkResponse bulkResponse) {
//
//            }
//
//            @Override
//            public void afterBulk(long l, BulkRequest bulkRequest, Throwable throwable) {
//
//            }
//        }).setBulkSize(new ByteSizeValue(1000, ByteSizeUnit.BYTES ))
//                .setFlushInterval(new TimeValue(10000))
//                .setConcurrentRequests(1)
//                .setBackoffPolicy(BackoffPolicy.constantBackoff(new TimeValue(20000) , 6))
//                .build();
//    }
}
