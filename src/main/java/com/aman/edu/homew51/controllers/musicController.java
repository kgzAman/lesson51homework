package com.aman.edu.homew51.controllers;

import com.aman.edu.homew51.repositories.musicRepositories;
import com.aman.edu.homew51.services.musicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class musicController {
    private final musicRepositories repository;
    private final musicService musicService;

//    public musicController(musicRepositories repositories, com.aman.edu.homew51.services.musicService musicService) {
//        this.repository = repositories;
//        this.musicService = musicService;
//    }


}
