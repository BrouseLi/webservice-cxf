package com.angshi.mimicwebpolicy.Config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

public class MyfeignConfiguration {
    //自定义重试次数
    @Bean
    public Retryer feignRetryer() {
        Retryer retryer = new Retryer.Default(100, 1000, 4);
        return retryer;
    }
}
