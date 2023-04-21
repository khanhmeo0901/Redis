package com.example.demoredis;

public interface BookService {
    void save(Book book);
    Book findById(String id);
    void clearCache();
}
