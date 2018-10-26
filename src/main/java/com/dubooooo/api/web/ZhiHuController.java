package com.dubooooo.api.web;

import com.dubooooo.api.common.Result;
import com.dubooooo.api.service.impl.ZhiHuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zhihu")
public class ZhiHuController {

    @Autowired
    ZhiHuServiceImpl zhiHuService;

    @RequestMapping("latest")
    public Result latest() {
        return zhiHuService.latest();
    }

}
