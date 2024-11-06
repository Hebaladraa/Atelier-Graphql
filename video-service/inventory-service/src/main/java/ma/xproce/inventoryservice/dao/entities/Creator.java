package ma.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "creator")
    private List<Video> videos;
}
