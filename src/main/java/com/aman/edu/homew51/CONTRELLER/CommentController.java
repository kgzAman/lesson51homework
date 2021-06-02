package com.aman.edu.homew51.CONTRELLER;

import com.aman.edu.homew51.SERVICE.CommentService;
import com.aman.edu.homew51.SERVICE.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final LikeService likeService;
}
