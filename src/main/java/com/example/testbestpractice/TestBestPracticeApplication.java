package com.example.testbestpractice;

import com.example.testbestpractice.item.ItemService;
import com.example.testbestpractice.user.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableConfigurationProperties(ApiProperties.class)
@SpringBootApplication
public class TestBestPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBestPracticeApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(ApiProperties apiProperties) {
        return new RestTemplateBuilder().rootUri(apiProperties.getBaseurl()).build();
    }

    @Bean
    public UserService userService(ApiProperties apiProperties, RestTemplate restTemplate) {
        return new UserService(apiProperties, restTemplate);
    }

    @Bean
    public ItemService itemServiceService() throws InterruptedException {
        Thread.sleep(2000);
        return new ItemService();
    }

 }
