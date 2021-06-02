package com.aman.edu.homew51.REPOSITORY;


import com.aman.edu.homew51.ENTITY.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String login);
    List<User> findByName(String name);
    Optional<User> findByEmail(String email);
    User findByUsername(String username);
    User findUserById(String id);
    List<User>findAll();
}
