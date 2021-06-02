package com.aman.edu.homew51.DTO;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "images")
public class ImageDto {
}
