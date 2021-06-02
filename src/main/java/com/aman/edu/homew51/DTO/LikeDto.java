package com.aman.edu.homew51.DTO;

import com.aman.edu.homew51.ENTITY.Like;
import com.aman.edu.homew51.ENTITY.Publication;
import com.aman.edu.homew51.ENTITY.User;
import lombok.*;

import java.time.LocalDate;


@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class LikeDto {
    private User user;
    private Publication publication;
    private LocalDate date;

    public static LikeDto from(Like like) {
        return builder()
                .date(like.getLocalDate())
                .publication(like.getPublication())
                .user(like.getUser())
                .build();
    }
}
