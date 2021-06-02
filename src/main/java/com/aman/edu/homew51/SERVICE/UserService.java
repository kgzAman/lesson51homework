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

}
