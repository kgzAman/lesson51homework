package com.aman.edu.homew51.ENTITY;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "images")
public class Image {

    public static final Image NO_IMAGE = Image.builder().id("-NO-IMAGE-").build();

    @Id
    @Builder.Default
    private final String id = UUID.randomUUID().toString();

    @Builder.Default
    private final Binary publicationData = new Binary(new byte[0]);
}
