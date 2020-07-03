package com.example.springelk;

import com.alibaba.fastjson.JSON;
import org.apache.http.entity.ContentType;
import org.apache.tomcat.util.json.JSONParser;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.template.get.GetComponentTemplateAction;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


@RestController
public class IndexAction {

     private final static Logger log = LoggerFactory.getLogger(IndexAction.class);

//     @Autowired
//     public ElasticsearchTemplate elasticsearchTemplate;
     @Resource
RestHighLevelClient restHighLevelClient;

     @RequestMapping("/createIndex")
     public String createIndex() throws IOException {
//          elasticsearchTemplate.createIndex(Animal.class);
          Cat cat = new Cat("fatCaat", "cat", "110.0");
          CreateIndexRequest request   = new CreateIndexRequest("animal");

          request.source(
                  "  {\n" +
                          "      \"properties\": {\n" +
                          "        \"message\": {\n" +
                          "          \"type\": \"text\"\n" +
                          "        }\n" +
                          "      }\n" +
                          "  }",
                  XContentType.JSON);
          restHighLevelClient.indices().createAsync(request, RequestOptions.DEFAULT,
                  new ActionListener<CreateIndexResponse>() {
                       @Override
                       public void onResponse(CreateIndexResponse createIndexResponse) {
                            log.info("yes");
                       }

                       @Override
                       public void onFailure(Exception e) {
                            log.info("errot");
                       }
                  });
        //  restHighLevelClient.index( request, RequestOptions.DEFAULT);
          return "success";
     }

     @RequestMapping("/deleteIndex")
     public void deleteIndex() throws IOException {
          DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("animal");
          restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
     }

     @RequestMapping("/addDoc")
    public void addDoc() throws IOException {
         IndexRequest indexRequest= new IndexRequest("animalcat2");
         Cat cat = new Cat("fatCaat", "cat", "110.0");
         Map<String, Object> mappings  = new Hashtable<>();
         Map<String, Object> mappings2  = new Hashtable<>();
         mappings.put("name",cat.getName());
         mappings.put("category",cat.getCategory());
         mappings.put("weight",cat.getWeight());
         indexRequest.source(mappings);
         restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
     }

    @RequestMapping("/search")
    public void search() throws IOException {
        SearchRequest indexRequest= new SearchRequest("animalcat2");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("name", "fatCaat"));
        indexRequest.source(searchSourceBuilder);
        SearchResponse response =  restHighLevelClient.search(indexRequest, RequestOptions.DEFAULT);
        SearchHits hits =  response.getHits();
        for (SearchHit hit:hits
             ) {
            System.out.println(hit.getSourceAsString());
        }
    }

    @RequestMapping("/termSearch")
    public void termSearch() throws IOException {
        SearchRequest indexRequest= new SearchRequest("animalcat2");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("name", "fatCaat"));
        indexRequest.source(searchSourceBuilder);
        SearchResponse response =  restHighLevelClient.search(indexRequest, RequestOptions.DEFAULT);
        SearchHits hits =  response.getHits();
        for (SearchHit hit:hits
        ) {
            System.out.println(hit.getSourceAsString());
        }
    }


    @RequestMapping("/searchAge")
    public List<Employee> seachAge(){
         SearchRequest searchRequest = new SearchRequest("employee");
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("age", 31);
        queryBuilder.must(termQueryBuilder);
        List<Employee> res= null;
        try {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(queryBuilder);
            searchSourceBuilder.from(1);
            searchSourceBuilder.size(10);
            searchSourceBuilder.sort("age");
           SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
           SearchHit[] hits = response.getHits().getHits();
           res = new ArrayList<>(hits.length);
           for (SearchHit searchHit: hits){
               res.add(JSON.parseObject(searchHit.getSourceAsString(), Employee.class));
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping("/bulk")
    public void bulk(){
        
    }

}
