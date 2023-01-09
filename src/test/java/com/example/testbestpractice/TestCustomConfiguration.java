package com.example.testbestpractice;

import com.example.testbestpractice.item.ItemService;
import com.example.testbestpractice.user.UserService;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;


/**
 * Created by Jakub Krhovják on 1/6/23.
 */

public class TestCustomConfiguration {

    @Bean
    public ItemService itemService() {
        return Mockito.mock(ItemService.class);
    }

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }



}
