package com.example.testbestpractice.user;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testbestpractice.IntegrationTest;
import com.example.testbestpractice.TestUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.matching.EqualToPattern;

import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */

class UserControllerIT extends IntegrationTest {


    @Test
    void fetchUsers() throws Exception {
        var responseInJson = TestUtils.readFileAsString("user/usersResponse.json");

        mockServer.stubFor(WireMock.get("/api/e99ba7e0?count=10&key=123")
                .willReturn(aResponse()
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)
                        .withBody(responseInJson)));

        mvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[?(@.id == 1 && @.username == 'Marmaduke' && @.email == 'mcarslaw0@tiny.cc')]").isNotEmpty())
                .andExpect(jsonPath("$.[?(@.id == 2 && @.username == 'Kassia' && @.email == 'ksturte1@dagondesign.com')]").isNotEmpty());

    }

    @Test
    void fetchUsersAssetJson() throws Exception {
        var serverResponse = TestUtils.readFileAsString("user/usersResponse.json");
        var expected = TestUtils.readFileAsString("user/usersExpected.json");

        mockServer.stubFor(WireMock.get("/api/e99ba7e0?count=10&key=123")
                .willReturn(aResponse()
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)
                        .withBody(serverResponse)));

        var result = mvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse().getContentAsString();

        TestUtils.assertJsonEquals(result, expected);



    }



}
