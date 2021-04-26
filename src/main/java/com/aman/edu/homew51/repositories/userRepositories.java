package com.aman.edu.homew51.repositories;

import com.aman.edu.homew51.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface userRepositories  extends CrudRepository<User, String> {
    Optional<User> findByName(String name);
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
    Boolean existsByEAndEmail(String email);

}
