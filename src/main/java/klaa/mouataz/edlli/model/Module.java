package klaa.mouataz.edlli.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_module")
public class Module {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    private Speciality speciality;
    @JsonIgnore
    @OneToMany(mappedBy = "module")
    private Set<Note> notes = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
}
