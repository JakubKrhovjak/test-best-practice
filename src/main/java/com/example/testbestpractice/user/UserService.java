package com.example.testbestpractice.user;

import com.example.testbestpractice.ApiProperties;
import com.fasterxml.jackson.core.type.TypeReference;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * Created by Jakub Krhovják on 1/4/23.
 */

@RequiredArgsConstructor
public class UserService {

    private final ApiProperties apiProperties;

    private final RestTemplate restTemplate;

    public List<User> fetchUsers() {
        return restTemplate.exchange(apiProperties.getUserPath(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {})
                .getBody();
    }

}
