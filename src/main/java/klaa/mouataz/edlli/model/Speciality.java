package klaa.mouataz.edlli.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_speciality")
public class Speciality {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "speciality")
    private Set<Student> students = new HashSet<>();
    @OneToMany(mappedBy = "speciality")
    private Set<Module> modules = new HashSet<>();

}
