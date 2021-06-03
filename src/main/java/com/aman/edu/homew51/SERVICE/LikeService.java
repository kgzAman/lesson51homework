package com.aman.edu.homew51.SERVICE;

import com.aman.edu.homew51.DTO.LikeDto;
import com.aman.edu.homew51.ENTITY.Like;
import com.aman.edu.homew51.ENTITY.Publication;
import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.REPOSITORY.LikeRepository;
import com.aman.edu.homew51.REPOSITORY.PublicationRepository;
import com.aman.edu.homew51.REPOSITORY.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LikeService {

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;
    private final LikeRepository likeRepository;

    public boolean existsThereAnyLikeByUserAndPost(String publicationId, String id) {
        User userById = userRepository.findUserById(id);
        Publication publicationsId = (Publication) publicationRepository.findPublicationById(publicationId);
        return likeRepository.existsLikeByUserAndPublication(userById, publicationsId);
    }

    public LikeDto addLike(String publicationId, String userId) throws Exception {

        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new Exception("There is not such a post with " + publicationId + "id"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("There is no such a user with " + userId + " id"));

        return LikeDto.from(Like.createLike(user, publication, LocalDate.now()));
    }

    public boolean deleteLike(String likeId) {
        likeRepository.deleteById(likeId);
        return true;
    }

    public Like findById(String id) throws Exception {
        return likeRepository.findById(id).orElseThrow(()->
                new Exception("There is not suck like"));
    }
}
