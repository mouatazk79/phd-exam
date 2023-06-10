package klaa.mouataz.edlli.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_note")
public class Note {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentcode_ref", referencedColumnName = "studentcode")
    private Student student;
    private String moduleName;
    private String note1;
    private String enseignant1;
    private String note2;
    private String enseignant2;
    private String note3;
    private String enseignant3;
    private boolean thereIsDifference;
    private String noteFinale;

    @JsonBackReference
    public Module getModule() {
        return module;
    }
}
