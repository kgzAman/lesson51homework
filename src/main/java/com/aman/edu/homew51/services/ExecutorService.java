package com.aman.edu.homew51.services;

import com.aman.edu.homew51.entities.Executor;
import com.aman.edu.homew51.repositories.ExecutorRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExecutorService {
    private final ExecutorRepositories executorRepositories;

    public List<Executor> getExecutorByName(String name){
        return this.executorRepositories.findByNameContaining(name);
    }


}
