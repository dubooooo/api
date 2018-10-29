package com.dubooooo.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ApiInfo {

    /*api描述*/
    String desc();

}
