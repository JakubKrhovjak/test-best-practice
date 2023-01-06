package com.example.testbestpractice.item;

import com.example.testbestpractice.user.User;
import com.example.testbestpractice.user.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */
@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public String getUsers() {
        return itemService.doSomeStaff();
    }

}
