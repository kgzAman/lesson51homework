package com.aman.edu.homew51.DTO;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ImageDto {
        private String imageId;
}
