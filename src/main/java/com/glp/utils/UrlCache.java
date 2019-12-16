package com.glp.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author zmm
 * @date 2019/12/12
 */
@Configuration
public class UrlCache {
@Bean
public Cache<String, Integer> getCache() {
    return CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.SECONDS).build();// 缓存有效期为2秒
}
}
