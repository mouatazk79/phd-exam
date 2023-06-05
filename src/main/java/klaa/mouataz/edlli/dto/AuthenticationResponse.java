package klaa.mouataz.edlli.dto;

import klaa.mouataz.edlli.enumerations.Role;
import klaa.mouataz.edlli.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  private Role role;
  private Admin admin;
  private Student student;
  private VDoyen vDoyen;
  private Enseignant enseignant;
  private CFD cfd;
  private Integer id;


}
