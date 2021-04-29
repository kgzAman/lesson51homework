package com.aman.edu.homew51.services;

import com.aman.edu.homew51.entities.User;
import com.aman.edu.homew51.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepositories userRepositories;

    public User save(User user) {
       final Optional<User> byName= this.userRepositories.findByName(user.getUserName());

        return byName.orElseGet(() -> this.userRepositories.save(user));
    }

    public Boolean checkIfExist(String email){
        return userRepositories.existsByEAndEmail(email);
    }

    public Optional<User> byEmail(String email){
        return userRepositories.findByEmail(email);
    }


}
