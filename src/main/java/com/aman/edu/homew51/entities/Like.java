package com.aman.edu.homew51.entities;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Builder
@Entity
@Document(collection = "likies")
@NoArgsConstructor
public class Like {

    @DBRef
    private User user;

    @DBRef
    private Track track;

    private Boolean negative = Boolean.FALSE;
}
