package com.dubooooo.api.common;

import com.alibaba.fastjson.JSONObject;

public class ApplicationUtil {

    public static JSONObject str2json(String str) {
        try {
            return JSONObject.parseObject(str);
        } catch (Exception e) {
            return null;
        }
    }
}
