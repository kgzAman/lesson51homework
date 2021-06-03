package com.aman.edu.homew51.SERVICE;

import com.aman.edu.homew51.DTO.PublicationDto;
import com.aman.edu.homew51.ENTITY.Publication;
import com.aman.edu.homew51.ENTITY.Subscribe;
import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.REPOSITORY.*;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.messaging.Subscription;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final SubscribeRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    public List<Publication> findAllMySubPosts(String id) {
        List<Subscribe> allByUserId = subscriptionRepository.findAllPublicationByUserId(id);
        List<Publication> posts = new ArrayList<>();
        for (Subscribe s :
                allByUserId) {
            List<Publication> publicationByUser = publicationRepository.findAllPublicationByUserId(s.getToUser().getId());
            posts.addAll(publicationByUser);
        }
        return posts;
    }

    public Publication findById(String id) throws Exception {
        return publicationRepository.findById(id).orElseThrow(() -> new Exception("There is no such publication"));
    }

    public List<PublicationDto> publicationService(String id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("There is no such a user with " + id + " id"));
        List<Publication> allPublicationByUserId = publicationRepository.findAllPublicationByUserId(id);
        List<PublicationDto> posts = new ArrayList<>();
        for (Publication publication : allPublicationByUserId) {
            posts.add(PublicationDto.from(publication));
        }
        return posts;
    }

    public void save(Publication publication) {
        publicationRepository.save(publication);
    }

    public boolean deletePost(String publicationId) {
        Publication publicationById = (Publication) publicationRepository.findPublicationById(publicationId);
        likeRepository.deleteLikesByPublicationId(publicationId);
        commentRepository.deleteCommentsByPublicationId(publicationId);
        publicationRepository.deleteById(publicationId);
        return true;
    }
}
