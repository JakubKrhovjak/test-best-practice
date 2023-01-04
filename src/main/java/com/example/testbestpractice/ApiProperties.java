package com.example.testbestpractice;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * Created by Jakub Krhovják on 1/4/23.
 */


@Data
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

    private String baseurl;
    private String userPath;


}
