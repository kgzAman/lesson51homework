package com.aman.edu.homew51.REPOSITORY;

import com.aman.edu.homew51.ENTITY.Like;
import com.aman.edu.homew51.ENTITY.Publication;
import com.aman.edu.homew51.ENTITY.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends MongoRepository<Like,String> {
    boolean existsLikeByUserAndPublication(User userById, Publication publicationId);
    void deleteLikesByPublicationId(String publicationId);
}
