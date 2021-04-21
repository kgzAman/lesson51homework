package com.aman.edu.homew51.services;

import com.aman.edu.homew51.repositories.musicRepositories;
import lombok.Data;
import org.springframework.stereotype.Service;


@Data
@Service
public class musicService {
    private final musicRepositories musicRepositories;

    public musicService(com.aman.edu.homew51.repositories.musicRepositories musicRepositories) {
        this.musicRepositories = musicRepositories;
    }
}
