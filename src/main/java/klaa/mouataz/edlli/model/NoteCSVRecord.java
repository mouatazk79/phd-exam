package klaa.mouataz.edlli.model;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteCSVRecord {
    @CsvBindByName
    private Integer id;
    @CsvBindByName
    private Integer module;
    @CsvBindByName
    private UUID student;
    @CsvBindByName
    private String note1;
    @CsvBindByName
    private String note2;
    @CsvBindByName
    private String note3;
    @CsvBindByName
    private String noteFinale;
}
