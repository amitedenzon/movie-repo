package org.example.util;

import org.example.service.EntityGenerationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final EntityGenerationService entityGenerationService;

    public AppRunner(EntityGenerationService entityGenerationService) {
        this.entityGenerationService = entityGenerationService;
    }

    @Override
    public void run(String... args) throws Exception {
        entityGenerationService.generateEntities();
    }
}
