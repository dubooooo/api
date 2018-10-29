package com.dubooooo.api.common;

import com.dubooooo.api.annotation.ApiInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Component
public class ApiInfoConfig implements InitializingBean, BeanClassLoaderAware, ApplicationContextAware {

    private ApplicationContext ac;
    private ClassLoader classLoader;

    @Override
    public void afterPropertiesSet() throws Exception {
        RequestMappingHandlerMapping handlerMapping = (RequestMappingHandlerMapping) ac.getBean(HandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();
        map.forEach((requestMappingInfo, handlerMethod) -> {
            Class<?> beanType = handlerMethod.getBeanType();
            ApiInfo apiInfo = beanType.getAnnotation(ApiInfo.class);
            if (apiInfo != null) {
                System.out.println(requestMappingInfo);
                System.out.println(handlerMethod);
                System.out.println();
            }
        });
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }

}
