package com.aman.edu.homew51.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;

@Data
@Document(collation = "albums" )
public class Album extends BaseEntity {

    private int year;
    private String name;

    List<Track> tracks = new ArrayList<>();
}
