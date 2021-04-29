package com.aman.edu.homew51.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode
@Document(collation = "tracks")
public class Track extends BaseEntity {
    private String name ;

    @DBRef
    private Executor actor;

    @DBRef
    private Album album;

}

