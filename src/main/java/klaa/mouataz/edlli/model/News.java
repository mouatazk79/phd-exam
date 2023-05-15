package klaa.mouataz.edlli.model;

import jakarta.persistence.*;
import klaa.mouataz.edlli.enumerations.NewsType;
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
@Table(name = "_information")
public class News {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private NewsType type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;



}
