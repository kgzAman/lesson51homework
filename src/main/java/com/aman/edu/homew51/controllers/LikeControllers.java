package com.aman.edu.homew51.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/like")
public class LikeControllers {
    @PostMapping("/{userId}/{trackname}")
    public void setLike(@PathVariable String userId, @PathVariable String trackname, @RequestParam(defaultValue="FALSE") Boolean negative){
    }
}
