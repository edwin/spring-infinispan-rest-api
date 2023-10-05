package com.edw.controller;

import com.edw.bean.User;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

    @GetMapping(path = "/get-some-cache")
    public Map getSomeCache() {
        return (Map) cacheManager.getCache("some-cache").getAll(new HashSet<>(){{
            add(1);
            add(2);
        }});
    }

}