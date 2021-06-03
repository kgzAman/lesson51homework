package com.aman.edu.homew51.SERVICE;

import com.aman.edu.homew51.DTO.UserDto;
import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.REPOSITORY.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    public final UserRepository userRepository;

    public List<UserDto> findUserByName(String name) {
        List<User> names = userRepository.findByName(name);
        List<UserDto> users = new ArrayList<>();
        for (User user : names) {
            users.add(UserDto.from(user));
        }
        return users;
    }

    public UserDto addUser(User user) {
        return UserDto.from(userRepository.save(User.createUser(user.getName(), user.getUsername(), user.getEmail(), user.getNoEncodePassword())));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("user with email %s not found", s)));
    }

    public UserDto findUserByEmail(String email) {
        return UserDto.from(userRepository.findByEmail(email).get());
    }


    public UserDto findUserByLogin(String username) {
        return UserDto.from(userRepository.findByUsername(username));
    }

    public boolean existsThereAnyUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsThereAnyUserByUsername(String login) {
        return userRepository.existsByUsername(login);
    }

    public @ResponseBody List<User> getAll(){
            return this.userRepository.findAll();
    }

    public User getUser() {
        Random r = new Random();
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(u -> users.add(u));
        return users.get(r.nextInt(users.size()));
    }
}
