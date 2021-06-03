package com.aman.edu.homew51.CONTRELLER;

import com.aman.edu.homew51.DTO.ImageDto;
import com.aman.edu.homew51.SERVICE.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@AllArgsConstructor
public class ImageController {

    private final ImageService imagesService;

    @PostMapping
    public ImageDto addPostImage(@RequestParam("file") MultipartFile file) {
        return imagesService.addImage(file);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<Resource> serveFile(@PathVariable String imageId) throws Exception {
        Resource resource = imagesService.getById(imageId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(resource);
    }


}
