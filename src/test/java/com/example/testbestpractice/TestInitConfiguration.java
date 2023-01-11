package com.example.testbestpractice;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.icegreen.greenmail.util.GreenMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */



@Profile("test")
public class TestInitConfiguration {

    @Autowired
    private WireMockServer mockServer;

    @Autowired
    private GreenMail greenMail;



    @PostConstruct
    public void init() {
        mockServer.start();
        greenMail.start();
    }
    @PreDestroy
    public void destroy() {
        mockServer.stop();
        greenMail.stop();
    }




}
