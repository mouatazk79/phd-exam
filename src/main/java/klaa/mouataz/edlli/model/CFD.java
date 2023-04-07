package klaa.mouataz.edlli.model;

import jakarta.persistence.*;
import klaa.mouataz.edlli.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_cfd")
public class CFD {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String number;
    @OneToOne(mappedBy = "cfd")
    private User user;
}
