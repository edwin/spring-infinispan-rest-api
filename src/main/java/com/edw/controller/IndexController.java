package com.edw.controller;

import com.edw.bean.GenMdBankDTO;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

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
        Map responseMap = (Map) cacheManager.getCache("some-cache").getAll(new HashSet<>(){{
            add(1);
            add(2);
        }});

        // get fi_plafond
        logger.info("content of fi_plafond is {}", new BigDecimal(((GenMdBankDTO)responseMap.get(1)).getFi_plafond()));

        return responseMap;
    }

    @GetMapping(path = "/add-some-cache")
    public GenMdBankDTO addSomeCache(@RequestParam String bank_id,
                                     @RequestParam String sub_account_code,
                                     @RequestParam String sub_description,
                                     @RequestParam String fi_bank,
                                     @RequestParam Integer priority,
                                     @RequestParam String bank_code,
                                     @RequestParam String bank_branch,
                                     @RequestParam String bank_account_no,
                                     @RequestParam String bank_account_name,
                                     @RequestParam String currency_code,
                                     @RequestParam Double fi_plafond,
                                     @RequestParam Double bank_fee,
                                     @RequestParam String contact_person,
                                     @RequestParam String contact_telephone,
                                     @RequestParam String email,
                                     @RequestParam String record_status) {
        cacheManager.getCache("some-cache").put(bank_id, new GenMdBankDTO(bank_id,
                sub_account_code, sub_description, fi_bank,
                priority, bank_code, bank_branch, bank_account_no,
                bank_account_name, currency_code, fi_plafond, bank_fee,
                contact_person, contact_telephone, email, record_status));
        return (GenMdBankDTO) cacheManager.getCache("some-cache").getOrDefault(bank_id, new GenMdBankDTO());
    }

}