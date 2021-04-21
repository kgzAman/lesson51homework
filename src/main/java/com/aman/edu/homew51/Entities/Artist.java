package com.aman.edu.homew51.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Data
@Document
public class Artist {

    @Id
    private String name;

    private String photo;

    private String info;


}
