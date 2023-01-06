package com.example.testbestpractice.item;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testbestpractice.IntegrationTest;
import com.example.testbestpractice.TestUtils;
import com.example.testbestpractice.user.User;
import com.example.testbestpractice.user.UserService;
import com.fasterxml.jackson.core.type.TypeReference;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */

@SpringBootTest
class ItemControllerIT extends IntegrationTest {

    @MockBean
    private ItemService itemService;


    void doSomeStaff() throws Exception {
        Mockito.when(itemService.doSomeStaff()).thenReturn("done-test");

        mvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", is("done-test")))

        ;

    }


}
