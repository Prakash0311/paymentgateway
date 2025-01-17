package com.example.paymentGateway;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
    List<UserSubscription> findByUserId(Long userId);

    UserSubscription save(UserSubscription userSubscription);
}
