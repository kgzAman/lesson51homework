package com.aman.edu.homew51.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode
@Document(collation = "executors")
@Entity
public class Executor extends BaseEntity {

    private String id;
    private String name;


}
