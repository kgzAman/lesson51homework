package com.aman.edu.homew51.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public abstract class  BaseEntity {

    @Id
    private String id;
}
