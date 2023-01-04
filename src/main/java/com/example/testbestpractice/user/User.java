package com.example.testbestpractice.user;

import lombok.Data;

/**
 * Created by Jakub Krhovják on 1/4/23.
 */

@Data
public class User {

    private long id;

    private String username;

    private String email;



    //curl -H "X-API-Key: 61758e60" https://my.api.mockaroo.com/users
}
