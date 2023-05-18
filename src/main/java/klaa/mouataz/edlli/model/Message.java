package klaa.mouataz.edlli.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="_message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String details;
    @ManyToOne
    @JoinColumn(name = "enseign_id", referencedColumnName = "id")
    private Enseignant enseignant;

}
