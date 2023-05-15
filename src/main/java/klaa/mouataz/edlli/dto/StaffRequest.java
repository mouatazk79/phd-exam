package klaa.mouataz.edlli.dto;

import klaa.mouataz.edlli.enumerations.Gender;
import klaa.mouataz.edlli.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffRequest {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Gender gender;
    private String number;
    private User user;

}
