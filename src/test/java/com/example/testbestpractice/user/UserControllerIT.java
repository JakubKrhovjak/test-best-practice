package com.example.testbestpractice.user;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testbestpractice.IntegrationTest;
import com.example.testbestpractice.TestUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
class UserControllerIT implements ApplicationContextAware {

    @MockBean
    private UserService userService;

    private MockMvc mvc;

    public void setApplicationContext(@NotNull ApplicationContext applicationContext) {
        mvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) applicationContext).build();
    }

    @Test
    void fetchUsers() throws Exception {

        var responseInJson = TestUtils.readFileAsString("user/usersResponse.json");
        var usersResponse = TestUtils.readJsonAsType(responseInJson, new TypeReference<List<User>>(){});

        Mockito.when(userService.fetchUsers()).thenReturn(usersResponse);

        mvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[?(@.id == 1 && @.username == 'Marmaduke' && @.email == 'mcarslaw0@tiny.cc')]").isNotEmpty())
                .andExpect(jsonPath("$.[?(@.id == 2 && @.username == 'Kassia' && @.email == 'ksturte1@dagondesign.com')]").isNotEmpty())

        ;

    }


}
