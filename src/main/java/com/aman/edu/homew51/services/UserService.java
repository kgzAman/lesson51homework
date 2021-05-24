package com.aman.edu.homew51.services;

import com.aman.edu.homew51.entities.User;
import com.aman.edu.homew51.repositories.UserRepositories;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepositories userRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = userRepositories.getByEmail(username);
        if(optUser.isEmpty()){
            throw new UsernameNotFoundException("Not found");
        }
        return optUser.get();
    }

    public User save(User user) {
       final Optional<User> byName= this.userRepositories.findByName(user.getUsername());

        return byName.orElseGet(() -> this.userRepositories.save(user));
    }

    public Boolean checkIfExist(String email){
        return userRepositories.existsByAndEmail(email);
    }

    public Optional<User> byEmail(String email){
        return userRepositories.findByEmail(email);
    }


}
