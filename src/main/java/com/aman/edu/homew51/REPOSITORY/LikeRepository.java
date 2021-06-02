package com.aman.edu.homew51.REPOSITORY;

import com.aman.edu.homew51.ENTITY.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<Like,String> {
}
