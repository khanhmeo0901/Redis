package com.example.demoredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private RedisTemplate<String, Book> redisTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    @Override
    public void save(Book book) {
        redisTemplate.opsForValue()
                .set(book.getId(), book);
    }

    @Override
    public Book findById(String id) {
        return redisTemplate.opsForValue()
                .get(id);
    }

    @Override
    public void clearCache() {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.flushDb();
            return null;
        });
    }
}
