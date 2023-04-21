package com.example.demoredis;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;



@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Book> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String , Book> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // Add some specific configuration here. Key serializers, etc.
        return template;
    }


}
