package com.edw.controller;

import com.edw.bean.User;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <pre>
 *     com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 05 Okt 2023 10:29
 */
@RestController
public class IndexController {

    @Autowired
    private RemoteCacheManager cacheManager;

    @GetMapping(path = "/")
    public HashMap index() {
        return new HashMap(){{
            put("hello", "world");
        }};
    }

    @GetMapping(path = "/get-user")
    public User getUsers(@RequestParam String name) {
        return (User) cacheManager.getCache("user-cache").getOrDefault(name, new User());
    }

    @GetMapping(path = "/add-user")
    public User addUsers(@RequestParam String name, @RequestParam Integer age, @RequestParam String address) {
        cacheManager.getCache("user-cache").put(name, new User(name, age, address));
        return (User) cacheManager.getCache("user-cache").getOrDefault(name, new User());
    }

}