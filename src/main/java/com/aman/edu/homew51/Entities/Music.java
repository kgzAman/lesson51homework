package com.aman.edu.homew51.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Music {
    @Id

    protected String id;

    private String name;

    private Album album;

    private Artist actor;

}
