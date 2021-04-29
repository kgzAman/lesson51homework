package com.aman.edu.homew51.controllers;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/track")
public class TrackController {

    @GetMapping()
    public List<TrackDto> getByMusician(@RequestParam String  name){

    }

    @GetMapping
    public
}
