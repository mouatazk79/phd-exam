package klaa.mouataz.edlli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import klaa.mouataz.edlli.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_enseignant")
public class Enseignant {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer uid;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String number;
    @ManyToMany
    @JoinTable(
            name = "enseignant_module",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Module> modules = new ArrayList<>();
    @JsonIgnore
    @OneToOne(mappedBy = "enseignant")
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "enseignant")
    private List<Message> messages;
}
