package com.example.testbestpractice;

import com.example.testbestpractice.item.ItemService;
import com.example.testbestpractice.user.UserService;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.RequiredArgsConstructor;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */



public class TestCustomConfiguration {



    @Bean
    public WireMockServer mockServer() {
        var mockServer =  new WireMockServer(WireMockConfiguration.options().port(8060));
        mockServer.start();
        return mockServer;
    }


    @Bean
    public ItemService itemService() {
        return Mockito.mock(ItemService.class);
    }

//    @Bean
//    public UserService userService() {
//        return Mockito.mock(UserService.class);
//    }



//    @PostConstruct
//    public void init() {
//        mockServer.start();
//    }
//
//    @PreDestroy
//    public void destroy() {
//        mockServer.stop();
//    }




}
