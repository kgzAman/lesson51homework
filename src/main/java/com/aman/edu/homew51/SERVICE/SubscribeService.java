package com.aman.edu.homew51.SERVICE;

import com.aman.edu.homew51.DTO.SubscribeDto;
import com.aman.edu.homew51.ENTITY.Subscribe;
import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.REPOSITORY.SubscribeRepository;
import com.aman.edu.homew51.REPOSITORY.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.messaging.Subscription;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class SubscribeService {
    private final UserRepository userRepository;
    private final SubscribeRepository subscriptionRepository;

    public SubscribeDto addSubscription(String userId, String toUserId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("There is no such a user with " + userId + " id"));
        User toUser = userRepository.findById(toUserId)
                .orElseThrow(() -> new Exception("There is no such a user with " + userId + " id"));
        return SubscribeDto.from(subscriptionRepository.save(Subscribe.createSubscribe(user, toUser, LocalDate.now())));
    }

    public boolean deleteSubscription(String subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
        return true;
    }

    public Subscribe findById(String id) throws Exception {
        return subscriptionRepository.findById(id).orElseThrow(() ->
                new Exception("There is not suck subs"));
    }
}
