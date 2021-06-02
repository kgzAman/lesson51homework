package com.aman.edu.homew51.SERVICE;

import com.aman.edu.homew51.REPOSITORY.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository CommentRepository;
}
