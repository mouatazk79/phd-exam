package klaa.mouataz.edlli.model;

import jakarta.persistence.*;
import klaa.mouataz.edlli.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private String firstName;
    private String lastName;
    private UUID code;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String number;
    @OneToOne(mappedBy = "student")
    private User user;
}
