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

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */
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
