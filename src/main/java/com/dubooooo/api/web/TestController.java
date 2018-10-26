package com.dubooooo.api.web;

import com.dubooooo.api.common.ApplicationException;
import com.dubooooo.api.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("index")
    public Result index() {
        return Result.ok("Hello world");
    }

    @RequestMapping("voidtest")
    public void voidTest() {
        throw new RuntimeException("voidtest");
    }

    @RequestMapping("execption")
    public void execption() {
        throw ApplicationException.build("001", "异常测试");
    }

}
