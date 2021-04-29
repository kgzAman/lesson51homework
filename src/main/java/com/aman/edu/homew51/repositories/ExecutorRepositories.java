package com.aman.edu.homew51.repositories;

import com.aman.edu.homew51.entities.Executor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface ExecutorRepositories extends MongoRepository<Executor,String> {
    List<Executor> findByNameContaining(String name);
}
