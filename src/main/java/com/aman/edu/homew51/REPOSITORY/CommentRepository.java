package com.aman.edu.homew51.REPOSITORY;


import com.aman.edu.homew51.ENTITY.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
