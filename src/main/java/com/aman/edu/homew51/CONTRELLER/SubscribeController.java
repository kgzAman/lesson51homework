package com.aman.edu.homew51.CONTRELLER;

import com.aman.edu.homew51.DTO.SubscribeDto;
import com.aman.edu.homew51.ENTITY.Subscribe;
import com.aman.edu.homew51.ENTITY.User;
import com.aman.edu.homew51.SERVICE.SubscribeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/subscription")
public class SubscribeController {
    private final SubscribeService subscriptionService;

    @PostMapping("/{id}")
    public SubscribeDto addSubs(@PathVariable String id, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        return subscriptionService.addSubscription(user.getId(), id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubs(@PathVariable String id, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        Subscribe subscription = subscriptionService.findById(id);

        if (subscription.getUser().getId().equals(user.getId())) {
            if (subscriptionService.deleteSubscription(id)) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
