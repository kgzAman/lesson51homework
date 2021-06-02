package com.aman.edu.homew51.CONTRELLER;

import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.SERVICE.UserService;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Data
public class UserController {

    private UserService service;

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAll() {
        return service.getAll();
    }

}
