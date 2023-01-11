package com.example.testbestpractice.item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testbestpractice.IntegrationTest;
import com.example.testbestpractice.TestUtils;
import com.icegreen.greenmail.util.GreenMailUtil;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import javax.mail.internet.MimeMessage;

import io.vavr.collection.List;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */


class ItemControllerIT extends IntegrationTest {

    @Autowired
    private ItemService itemService;


    @Test
    void doSomeStaff() throws Exception {
        mvc.perform(get("/items"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", is("done")));

        var emails = Arrays.asList(greenMail.getReceivedMessages());
        var receivedMessage = TestUtils.findEmailByRecipient(emails, "noreply@test.com");

        Assertions.assertThat(GreenMailUtil.getAddressList(receivedMessage.getAllRecipients())).isEqualTo("jakub.krhovjak@protonmail.com");
        Assertions.assertThat(receivedMessage.getSubject()).isEqualTo("subject");
        Assertions.assertThat(GreenMailUtil.getBody(receivedMessage)).contains("email from item service");

    }


}
