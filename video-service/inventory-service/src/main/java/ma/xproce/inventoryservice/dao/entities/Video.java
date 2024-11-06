package ma.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String url;

    private String description;

    private LocalDate datePublication;

    @ManyToOne //@JoinColumn(name = "creator_id")
    private Creator creator;
}