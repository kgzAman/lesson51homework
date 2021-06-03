package com.aman.edu.homew51.SERVICE;

import com.aman.edu.homew51.DTO.ImageDto;
import com.aman.edu.homew51.ENTITY.Image;
import com.aman.edu.homew51.REPOSITORY.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bson.types.Binary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imagesRepository;

    public ImageDto addImage(MultipartFile file) {
        byte[] data = new byte[0];
        try {
            data = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        Binary bData = new Binary(data);
        Image image = Image.builder().publicationData(bData).build();

        imagesRepository.save(image);

        return ImageDto.builder()
                .imageId(image.getId())
                .build();
    }

    public Resource getById(String imageId) throws Exception {
        Image image = imagesRepository.findById(imageId)
                .orElseThrow(() -> new Exception("Post Image with " + imageId + " doesn't exists!"));
        return new ByteArrayResource(image.getPublicationData().getData());
    }
}
