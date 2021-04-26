package com.aman.edu.homew51.services;

import com.aman.edu.homew51.Entities.Music;
import com.aman.edu.homew51.repositories.musicRepositories;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Configuration
public class initDB {

    @Bean
    CommandLineRunner init(musicRepositories musicRepo){

        return(args) -> {
            musicRepo.deleteAll();

            List<Music> music = readMusic("data/tracks.json");

            musicRepo.saveAll(music);
        };

    }
    private static List<Music> readMusic(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            var data = Files.readString(Paths.get(fileName));
            var listType = new TypeReference<List<Music>>(){};
            return mapper.readValue(data, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }


}
