package com.example.testbestpractice;

import com.github.tomakehurst.wiremock.WireMockServer;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */
@ActiveProfiles("test")
@SpringBootTest(classes = {TestBestPracticeApplication.class, TestCustomConfiguration.class})
public abstract class IntegrationTest implements ApplicationContextAware {

    @Autowired
    protected WireMockServer mockServer;

    protected MockMvc mvc;

    public void setApplicationContext(@NotNull ApplicationContext applicationContext) {
        mvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) applicationContext).build();
    }

}
