package com.aman.edu.homew51.REPOSITORY;


import com.aman.edu.homew51.ENTITY.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {

    Slice<Comment> findAllByPublicationId(Pageable pageable, String postId);
    void deleteCommentsByPublicationId(String id);

}
