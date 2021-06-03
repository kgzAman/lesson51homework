package com.aman.edu.homew51.CONTRELLER;

import com.aman.edu.homew51.DTO.UserDto;
import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.SERVICE.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Data
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @PostMapping("/registration")
    public UserDto signUp(@RequestBody User user) throws Exception {
        if (service.existsThereAnyUserByEmail(user.getEmail())) {
            throw new Exception("There is a User with this email " + user.getEmail());
        } else if (service.existsThereAnyUserByUsername(user.getUsername())) {
            throw new Exception(("There is a User with this login" + user.getUsername()));
        }
        return service.addUser(user);
    }

    @GetMapping("name")
    public List<UserDto> findUsersByName(@RequestParam("name") String name) {
        return service.findUserByName(name);
    }

    @GetMapping("/login")
    public UserDto findUserByLogin(@RequestParam("login") String login) {
        return service.findUserByLogin(login);
    }

    @GetMapping("/email")
    public UserDto findUserByEmail(@RequestParam("email") String email) {
        return service.findUserByEmail(email);
    }


}
