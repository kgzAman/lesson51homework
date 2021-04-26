package com.aman.edu.homew51.repositories;


import com.aman.edu.homew51.Entities.Music;

import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface musicRepositories  extends CrudRepository<Music, String> {
    Boolean existsByLike(Music music);
}
