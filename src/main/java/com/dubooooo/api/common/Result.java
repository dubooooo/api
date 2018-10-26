package com.dubooooo.api.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class Result {

    private String code;
    private String msg;
    private Object data;

    public static Result ok() {
        return ok(null);
    }

    public static Result ok(String str) {
        JSONObject obj = ApplicationUtil.str2json(str);
        if (obj == null) {
            return ok((Object) str);
        } else {
            return ok(obj);
        }
    }

    public static Result ok(Object obj) {
        Result result = new Result();
        result.setCode("0");
        result.setMsg("success");
        if (obj instanceof String) {
            JSONObject jsonObject = ApplicationUtil.str2json((String) obj);
            if (jsonObject == null) {
                result.setData(obj);
            } else {
                result.setData(jsonObject);
            }
        } else {
            result.setData(obj);
        }
        return result;
    }

    public static Result error(String msg) {
        return error("1", msg);
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
