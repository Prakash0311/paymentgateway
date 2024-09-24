package com.example.paymentGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionMasterRepository subscriptionMasterRepository;

    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;

    public List<SubscriptionMaster> getAllSubscriptions() {
        return subscriptionMasterRepository.findAll();
    }

    public UserSubscription buySubscription(Long subscriptionMasterId, Long userId) {
        ScopedValue<Object> subscription = subscriptionMasterRepository.findById(subscriptionMasterId)

        UserSubscription userSubscription = new UserSubscription();
        userSubscription.setSubscriptionMasterId(subscriptionMasterId);
        userSubscription.setUserId(userId);
        LocalDate now = LocalDate.now();
        userSubscription.setStartDate(now);

        // Calculate end date based on subscription type
        if ("Monthly".equalsIgnoreCase((String) subscription.get())) {
            userSubscription.setEndDate(now.plusMonths(1));
        } else if ("Yearly".equalsIgnoreCase((String) subscription.get())) {
            userSubscription.setEndDate(now.plusYears(1));
        }

        return userSubscriptionRepository.save(userSubscription);
    }

    public List<UserSubscription> getLatestSubscription(Long userId) {
        return userSubscriptionRepository.findByUserId(userId);
    }
}
