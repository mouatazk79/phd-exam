package klaa.mouataz.edlli.model;

import jakarta.persistence.*;
import klaa.mouataz.edlli.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
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
    private String firstName;
    private String lastName;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String number;
    @OneToMany(mappedBy = "enseignant")
    private Set<Module> modules=new HashSet<>();
    @OneToOne(mappedBy = "enseignant")
    private User user;
    @OneToMany(mappedBy = "enseignant")
    private Set<Message> messages;
}
