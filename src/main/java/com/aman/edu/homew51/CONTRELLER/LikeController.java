package com.aman.edu.homew51.CONTRELLER;

import com.aman.edu.homew51.DTO.LikeDto;
import com.aman.edu.homew51.ENTITY.Like;
import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.SERVICE.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/likes")
@AllArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{publicationId}")
    public LikeDto addLike(@PathVariable String publicationId, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        return likeService.addLike(publicationId, user.getId());
    }

    @DeleteMapping("/delete/{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable String likeId, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        Like like = likeService.findById(likeId);
        if (like.getUser().getId().equals(user.getId())) {
            if (likeService.deleteLike(likeId))
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
