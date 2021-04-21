package com.aman.edu.homew51.repositories;

import com.aman.edu.homew51.Entities.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface musicRepositories  extends MongoRepository<Album, String> {
}
