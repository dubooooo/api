package com.dubooooo.api.service.impl;

import com.dubooooo.api.common.Result;
import com.dubooooo.api.common.SystemInfo;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl {

    public Result threadMXBeanInfo() {
        return Result.ok(SystemInfo.buildThreadMXBeanInfo(new SystemInfo()));
    }

    public Result info() {
        return Result.ok(SystemInfo.build());
    }

    public Result memory() {
        return Result.ok();
    }
}
