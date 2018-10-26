package com.dubooooo.api.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException extends RuntimeException {

    private String code = "1";
    private String msg = "error";

    public static ApplicationException build(String msg) {
        return build("1", msg);
    }

    public static ApplicationException build(String code, String msg) {
        ApplicationException ae = new ApplicationException();
        ae.setCode(code);
        ae.setMsg(msg);
        return ae;
    }

}
