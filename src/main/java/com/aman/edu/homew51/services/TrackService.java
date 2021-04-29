package com.aman.edu.homew51.services;

import com.aman.edu.homew51.entities.Executor;
import com.aman.edu.homew51.entities.Track;
import com.aman.edu.homew51.repositories.TrackRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {

    private final TrackRepositories trackRepositories;
    private final ExecutorService executorService;

    public List<Track> findByExecutor(String name){
        final List<Executor> executorsByName =this.executorService.getExecutorByName(name);
        return this.trackRepositories.findByAAndActorIn(executorsByName);
    }

    public List<Track> getByTrack(String name){
            return trackRepositories.findByName(name);
    }
}
