package com.example.paymentGateway;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionMasterRepository extends JpaRepository<SubscriptionMaster, Long> {
    List<SubscriptionMaster> findAll();

    void save(SubscriptionMaster subscriptionMaster);

    <T> ScopedValue<T> findById(Long subscriptionMasterId);
}

