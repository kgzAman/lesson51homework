package com.aman.edu.homew51.Entities;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document
public class Album {


    @Id
    @Column(name = "_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected String id;

    @Column(name = "name")
    private String name;
    private Artist artist;
    private String year;
    private String img ;
}
