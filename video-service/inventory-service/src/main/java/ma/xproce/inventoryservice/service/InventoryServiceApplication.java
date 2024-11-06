package ma.xproce.inventoryservice.service;


import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            List<Creator> creators = List.of(
                    Creator.builder().name("heba").email("hebaladraa@example.com").build(),
                    Creator.builder().name("hiba").email("hibasbai@example.com").build()
            );
            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(
                    Video.builder().name("Spring Boot Tutorial")
                            .url("http://example.com/spring-boot-tutorial")
                            .description("Learn Spring Boot basics.")
                            .datePublication(LocalDate.now())
                            .creator(creators.get(0))
                            .build(),
                    Video.builder().name("GraphQL Tutorial")
                            .url("http://example.com/graphql-tutorial")
                            .description("Learn GraphQL basics.")
                            .datePublication(LocalDate.now())
                            .creator(creators.get(1))
                            .build()
            );
            videoRepository.saveAll(videos);
        };
    }
}
