package com.example.paymentGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/masters")
    public ResponseEntity<List<SubscriptionMaster>> getAllSubscriptionMasters() {
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }

    @PostMapping("/buy")
    public ResponseEntity<UserSubscription> buySubscription(
            @RequestParam Long subscriptionMasterId,
            @RequestParam Long userId) {
        return ResponseEntity.ok(subscriptionService.buySubscription(subscriptionMasterId, userId));
    }

    @GetMapping("/latest")
    public ResponseEntity<List<UserSubscription>> getLatestSubscription(@RequestParam Long userId) {
        return ResponseEntity.ok(subscriptionService.getLatestSubscription(userId));
    }
}
