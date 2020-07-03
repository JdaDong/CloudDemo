package com.example.zipkinserver844;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

//@EnableZipkinServer
@zipkin2.server.internal.EnableZipkinServer
@EnableDiscoveryClient
@SpringBootApplication
//@EnableDiscoveryClient
public class Zipkinserver844Application {

    public static void main(String[] args) {
        SpringApplication.run(Zipkinserver844Application.class, args);
    }





    //    @Configuration
//    public class DbCountHealthIndicator implements HealthIndicator {
//        @Autowired
//        private CrudRepository crudRepository;
//        public DbCountHealthIndicator(CrudRepository crudRepository) {
//            this.crudRepository = crudRepository;
//        }
//        @Override
//        public Health health() {
//            try {
//                long count = crudRepository.count();
//                if (count >= 0) {
//                    return Health.up().withDetail("count", count).build();
//                } else {
//                    return Health.unknown().withDetail("count", count).build();
//                }
//            } catch (Exception e) {
//                return Health.down(e).build();
//            }
//        }
//    }
}
