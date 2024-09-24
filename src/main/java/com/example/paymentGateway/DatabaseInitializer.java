package com.example.paymentGateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner initDatabase(SubscriptionMasterRepository repository) {
        return args -> {
            repository.save(new SubscriptionMaster("Basic", "Monthly", 99));
            repository.save(new SubscriptionMaster("Basic", "Yearly", 999));
            repository.save(new SubscriptionMaster("Advanced", "Monthly", 199));
            repository.save(new SubscriptionMaster("Advanced", "Yearly", 1999));
        };
    }
}

