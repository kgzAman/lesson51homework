package com.aman.edu.homew51.ENTITY;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.messaging.Subscription;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Document(collection = "subscriptions")
public class Subscribe {
    @Id
    private String id = UUID.randomUUID().toString();

    @DBRef
    private User user;

    @DBRef
    private User toUser;

    private LocalDate date;


    public static Subscribe createSubscribe(User user, User toUser, LocalDate localDate) {
        Subscribe Subscribe = new Subscribe();
        Subscribe.setUser(user);
        Subscribe.setToUser(toUser);
        Subscribe.setDate(localDate);
        return Subscribe;
    }
}
