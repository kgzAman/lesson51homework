package com.aman.edu.homew51.REPOSITORY;


import com.aman.edu.homew51.ENTITY.Subscribe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribeRepository extends MongoRepository<Subscribe,String> {
    List<Subscribe> findAllPublicationByUserId(String id);
}
