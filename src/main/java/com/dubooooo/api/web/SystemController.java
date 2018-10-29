package com.dubooooo.api.web;

import com.dubooooo.api.common.Result;
import com.dubooooo.api.service.impl.SystemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system")
public class SystemController {

    @Autowired
    private SystemServiceImpl systemService;

    @RequestMapping("threadMXBeanInfo")
    public Result threadMXBeanInfo() {
        return systemService.threadMXBeanInfo();
    }

    @RequestMapping("memory")
    public Result memory() {
        return systemService.memory();
    }

    @RequestMapping("threads")
    public Result threads() {
        return systemService.memory();
    }

    @RequestMapping("process")
    public Result process() {
        return systemService.memory();
    }


}
