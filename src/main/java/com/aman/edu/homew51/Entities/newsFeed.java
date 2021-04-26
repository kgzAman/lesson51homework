package com.aman.edu.homew51.Entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collation = "newsFeed")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class newsFeed {

    @DBRef
    private List<User> user;
}
