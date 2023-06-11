package klaa.mouataz.edlli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import klaa.mouataz.edlli.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_student")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer uid;
    private String firstName;
    private String lastName;
    private String firstNameArabic;
    private String lastNameArabic;
    @Column(name = "studentcode",nullable = false,unique = true)
    private UUID code;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String number;
    private float moyen;
    @JsonIgnore
    @OneToOne(mappedBy = "student")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    private Speciality speciality;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student",fetch = FetchType.LAZY)
    private Set<Note> notes = new HashSet<>();


}
