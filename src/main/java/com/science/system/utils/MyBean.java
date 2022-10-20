package com.science.system.utils;

/**
 * @Description: TODO
 * @Author: Cauchy
 * @CreateTime: 2022/10/9
 */
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private final StringRedisTemplate template;

    public MyBean(StringRedisTemplate template){
        this.template = template;
    }

    public Boolean someMethod() {
        return this.template.hasKey("spring");
    }

}


