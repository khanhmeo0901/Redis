package com.example.demoredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookServiceImpl repository;


    public BookController(BookServiceImpl repository) {
        this.repository = repository;

    }

    @PostMapping("/create")
    public String newBook(@RequestBody Book newBook) {
        repository.save(newBook);
        return "Added";
    }

    @GetMapping("/get/{id}")
    public Book findOne(@PathVariable String id) {
        return repository.findById(id);
    }
    @Scheduled(cron = "*/30 * * * * *")
    @DeleteMapping("/clear")
    public void clearAll()
    {
        repository.clearCache();
    }

}
