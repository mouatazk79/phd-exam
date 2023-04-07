package klaa.mouataz.edlli.model;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCSVRecord {
    @CsvBindByName
    private Integer id;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String role;
    @CsvBindByName
    private String password;
}
