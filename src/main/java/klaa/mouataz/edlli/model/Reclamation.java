package klaa.mouataz.edlli.model;

import jakarta.persistence.*;
import klaa.mouataz.edlli.enumerations.RType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = " _reclamation")
public class Reclamation {
    @Id
    @GeneratedValue
    private Integer id;
    private RType type;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
