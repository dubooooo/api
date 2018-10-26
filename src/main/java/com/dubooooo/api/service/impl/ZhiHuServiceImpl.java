package com.dubooooo.api.service.impl;

import com.dubooooo.api.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZhiHuServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    public Result latest() {
        ResponseEntity<String> res = restTemplate.getForEntity("https://news-at.zhihu.com/api/4/news/latest", String.class);
        return Result.ok(res.getBody());
    }

}
