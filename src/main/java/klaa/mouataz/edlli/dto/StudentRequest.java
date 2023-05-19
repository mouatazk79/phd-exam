package klaa.mouataz.edlli.dto;

import klaa.mouataz.edlli.enumerations.Gender;
import klaa.mouataz.edlli.model.Speciality;
import klaa.mouataz.edlli.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String firstNameArabic;
    private String lastNameArabic;
    private LocalDate dob;
    private Gender gender;
    private String number;
    private User user;
    private Speciality speciality;
}
