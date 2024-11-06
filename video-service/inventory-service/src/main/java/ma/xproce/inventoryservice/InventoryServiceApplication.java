package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
    @Autowired
    CreatorRepository creatorRepository;
    @Autowired
    VideoRepository videoRepository;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(){
        return args ->{
            List<Creator> creators = List.of(
                    new Creator(1,"Heba LADRAA", "hebaladraa@gmail.com", null),
                    new Creator(2,"HIBA SBAI", "HIBasbai@gmail.com", null),
                    new Creator(3,"ikram SAMAMI", "samamiikram@gmail.com", null),
                    new Creator(4,"kawtar oumida", "oumidakawtar@gmail.com", null)
            );
            creatorRepository.saveAll(creators);

            int i=10;
            //List<Video> videos= new ArrayList<>();
            for(Creator creator : creators){
                List<Video> videos = List.of(
                        new Video(i,"Crochet for Beginners: The Basics", "https://example.com/crochet-basics",
                                "Learn the basic stitches and techniques to start crocheting.", LocalDate.now(), creator),
                        new Video(++i, "How to Crochet a Granny Square", "https://example.com/granny-square",
                                "Step-by-step guide to creating a classic granny square.", LocalDate.now(), creator),
                        new Video(++i, "Easy Crochet Flowers", "https://example.com/crochet-flowers",
                                "Create beautiful crochet flowers for decoration.", LocalDate.now(), creator),
                        new Video(++i, "Crochet a Cozy Blanket", "https://example.com/crochet-blanket",
                                "Learn how to crochet a warm and cozy blanket.", LocalDate.now(), creator)
                );
                i++;
                videoRepository.saveAll(videos);
            }
        };
    }

}