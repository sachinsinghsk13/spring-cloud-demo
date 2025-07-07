package com.techjs.cloud.suppliers.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableCaching
public class CacheConfiguration {

    @LoadBalanced
    private RestTemplate restTemplate;
}

