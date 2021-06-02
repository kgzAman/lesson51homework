package com.aman.edu.homew51.DTO;

import com.aman.edu.homew51.ENTITY.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDto {

    private String name;
    private String username;
    private String email;
    private String password;
    private Integer countOfPosts;
    private Integer countOfFollowers;
    private Integer countOfSubs;

    public static UserDto from(User user) {
        return builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .countOfPosts(user.getCountOfPosts())
                .countOfFollowers(user.getCountOfFollowers())
                .countOfSubs(user.getCountOfSubs())
                .build();
    }
}
