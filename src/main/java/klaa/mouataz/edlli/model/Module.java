package klaa.mouataz.edlli.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @OneToMany(mappedBy = "module")
    private Set<Note> notes = new HashSet<>();
    @ManyToMany(mappedBy = "modules",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Enseignant> enseignants = new ArrayList<>();
}
