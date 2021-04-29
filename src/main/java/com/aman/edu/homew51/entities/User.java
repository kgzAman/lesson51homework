package com.aman.edu.homew51.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collation = "users")
@Entity
public class User extends BaseEntity {
    private String userName;

}
