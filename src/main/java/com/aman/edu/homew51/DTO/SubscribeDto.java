package com.aman.edu.homew51.DTO;

import com.aman.edu.homew51.ENTITY.Subscribe;
import com.aman.edu.homew51.ENTITY.User;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscribeDto {

    private User user;
    private User toUser;
    private LocalDate date;

    public static SubscribeDto from(Subscribe subscription) {
        return builder()
                .user(subscription.getUser())
                .toUser(subscription.getToUser())
                .date(subscription.getDate())
                .build();
    }

}
