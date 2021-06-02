package com.aman.edu.homew51.DTO;

import com.aman.edu.homew51.ENTITY.Comment;
import com.aman.edu.homew51.ENTITY.Like;
import com.aman.edu.homew51.ENTITY.Publication;
import com.aman.edu.homew51.ENTITY.User;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PublicationDto {
    private String pathPicture;
    private String description;
    private LocalDate date;
    private User user;
    private List<Like> likes;
    private List<Comment> comments;

    public static PublicationDto from(Publication publication) {
        return builder()
                .pathPicture(publication.getPathPicture())
                .description(publication.getDescription())
                .date(publication.getDate())
                .user(publication.getUser())
                .comments(publication.getComments())
                .likes(publication.getLikes())
                .build();
    }
}
