package com.aman.edu.homew51.DTO;

import com.aman.edu.homew51.ENTITY.Comment;
import com.aman.edu.homew51.ENTITY.Publication;
import com.aman.edu.homew51.ENTITY.User;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class CommentDto {
    private Publication publication;
    private String message;
    private LocalDate localDate;
    private User user;

    public static CommentDto from(Comment comment) {
        return builder()
                .publication(comment.getPublication())
                .message(comment.getMessage())
                .localDate(comment.getLocalDate())
                .user(comment.getUser())
                .build();
    }
}
