package com.aman.edu.homew51.REPOSITORY;



import com.aman.edu.homew51.ENTITY.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublicationRepository extends MongoRepository<Publication, String> {
}
