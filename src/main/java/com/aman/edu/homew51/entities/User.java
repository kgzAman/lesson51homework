package com.aman.edu.homew51.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@CompoundIndex(def = "{'email': 1}")
@AllArgsConstructor
@EqualsAndHashCode
@Document(collation = "users")
@Entity
public class User extends BaseEntity {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();


    @Indexed
    private String email;
    private String userName;


    private String login;
    private String password;
}
