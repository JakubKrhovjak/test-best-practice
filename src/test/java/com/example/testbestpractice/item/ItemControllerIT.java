package com.example.testbestpractice.item;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testbestpractice.IntegrationTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Jakub Krhovják on 1/6/23.
 */


class ItemControllerIT extends IntegrationTest {

    @Autowired
    private ItemService itemService;


    @Test
    void doSomeStaff() throws Exception {
        Mockito.when(itemService.doSomeStaff()).thenReturn("done-test");

        mvc.perform(get("/items"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", is("done-test")))

        ;

    }


}
