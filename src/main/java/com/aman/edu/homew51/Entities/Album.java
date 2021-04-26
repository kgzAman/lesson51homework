package com.aman.edu.homew51.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Document(collation = "musics")
public class Album {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();


    private String name;
    private Artist artist;
    private String year;
    private String img ;
}
