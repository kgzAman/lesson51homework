package com.aman.edu.homew51.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collation = "like")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Like {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();


    @DBRef
    private Album album;


    @DBRef
    private Music music;
}
