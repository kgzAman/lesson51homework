package com.aman.edu.homew51.repositories;

import com.aman.edu.homew51.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
@NoRepositoryBean
public interface UserRepositories extends MongoRepository<User,String> {
    Optional<User> findByName(String userName);
    Boolean existsByEAndEmail(String email);
    Optional<User> findByEmail(String email);
}