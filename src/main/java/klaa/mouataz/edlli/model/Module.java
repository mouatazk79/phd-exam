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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    private Speciality speciality;
    @OneToMany(mappedBy = "module",fetch = FetchType.LAZY)
    private Set<Note> notes;

    @JsonBackReference
    public Set<Note> getNotes() {
        return notes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enseignant_id",referencedColumnName = "uid")
    private Enseignant enseignant;
}
