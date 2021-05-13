package com.aman.edu.homew51.repositories;

import com.aman.edu.homew51.entities.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;


public interface TrackRepositories extends MongoRepository<Track,String> {

    List<Track> findByName(String name);
    List<Track> findByActorAndActorIn(Collection executors);


}
