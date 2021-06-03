package com.aman.edu.homew51.SERVICE;

import com.aman.edu.homew51.DTO.CommentDto;
import com.aman.edu.homew51.ENTITY.Comment;
import com.aman.edu.homew51.ENTITY.Publication;
import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.REPOSITORY.CommentRepository;
import com.aman.edu.homew51.REPOSITORY.PublicationRepository;
import com.aman.edu.homew51.REPOSITORY.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    public Slice<CommentDto> findCommentByPublicationId(Pageable pageable, String postId) {
        Slice<Comment> comments = commentRepository.findAllByPublicationId(pageable, postId);
        return comments.map(CommentDto::from);
    }

    public CommentDto addComment(CommentDto commentData, String publicationId, String userId) throws Exception {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new Exception("There is not such a post with " + publicationId + "id"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("There is no such a user with " + userId + " id"));
        return CommentDto.from(commentRepository.save(Comment.createComment(publication, commentData.getMessage(), commentData.getLocalDate(), user)));
    }

    public boolean deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
        return true;
    }

    public Comment findById(String id) throws Exception {
        return commentRepository.findById(id).orElseThrow(()->
                new Exception("There is no such comment"));
    }
}
