package com.aman.edu.homew51.controllers;

import com.aman.edu.homew51.dto.TrackDto;
import com.aman.edu.homew51.services.TrackService;
import com.aman.edu.homew51.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/track")
@AllArgsConstructor
public class TrackController {

    private final TrackService trackService;
    private final UserService userService;
    private  final ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/{userToken}/musician")
    public List<TrackDto> getByExecutor(@RequestParam String name, @PathVariable String userToken){
        return this.trackService.findByExecutor(name).stream()
                .map(track -> modelMapper.map(track, TrackDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/track")
    public List<TrackDto> getByTrack(@RequestParam String name) {
        return this.trackService.getByTrack(name).stream()
                .map(track -> modelMapper.map(track, TrackDto.class))
                .collect(Collectors.toList());
    }
}
