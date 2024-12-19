//package com.hamburgueria.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
//
//import java.net.URI;
//
//@Configuration
//public class DynamoDbConfig {
//
//    @Bean
//    public DynamoDbClient dynamoDbConfig(){
//        return DynamoDbClient.builder()
//                .endpointOverride(URI.create("https://localhost.localstack.cloud:4566"))
//                .build();
//    }
//}
