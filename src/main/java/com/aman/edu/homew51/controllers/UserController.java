package com.aman.edu.homew51.controllers;

import com.aman.edu.homew51.dto.LoginUserIdDto;
import com.aman.edu.homew51.dto.UserIdDto;
import com.aman.edu.homew51.entities.User;
import com.aman.edu.homew51.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping()
//    public UserIdDto login(@RequestBody LoginUserIdDto userDto){
//            User user = User.builder()
//                    .(userDto.getName())
//                    .build();
//            this.userService.save(user);
//
//            final User logined = this.userService.save(user);
//            UserIdDto userIdDto = UserIdDto.builder()
//                    .token(logined.getId())
//                    .build();
//            return userIdDto;
//    }

    @PostMapping()
     public Boolean isExist (@RequestBody String name){
        return this.userService.checkIfExist(name);
    }

    @PostMapping()
    public Optional<User> getByEmail(@RequestBody String email){
        return this.userService.byEmail(email);
    }
}
