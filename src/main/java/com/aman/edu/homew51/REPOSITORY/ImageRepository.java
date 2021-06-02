package com.aman.edu.homew51.REPOSITORY;

import com.aman.edu.homew51.ENTITY.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image,String> {
}
