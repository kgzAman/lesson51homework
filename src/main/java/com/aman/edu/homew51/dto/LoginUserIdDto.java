package com.aman.edu.homew51.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginUserIdDto {
    private String name;
    private String email;

    private LocalDateTime localDateTime;

}
