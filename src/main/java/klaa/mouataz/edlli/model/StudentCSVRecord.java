package klaa.mouataz.edlli.model;

import com.opencsv.bean.CsvBindByName;
import klaa.mouataz.edlli.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCSVRecord {
    @CsvBindByName
    private Integer id;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String firstName;
    @CsvBindByName
    private String lastName;
    @CsvBindByName
    private String firstNameArabic;
    @CsvBindByName
    private String lastNameArabic;
    @CsvBindByName
    private UUID code;
    @CsvBindByName
    private Gender gender;
    @CsvBindByName
    private String number;
    @CsvBindByName
    private Speciality speciality;
    @CsvBindByName
    private LocalDate dob;
    @CsvBindByName
    private String role;
    @CsvBindByName
    private String password;
}
