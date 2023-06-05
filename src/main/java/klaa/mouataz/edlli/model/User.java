package klaa.mouataz.edlli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import klaa.mouataz.edlli.enumerations.Role;
import klaa.mouataz.edlli.security.token.Token;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
  @Id
  @GeneratedValue
  private Integer id;
    private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Token> tokens;
  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List <News> news;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "student_id", referencedColumnName = "id")
  private Student student;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "enseignant_id", referencedColumnName = "id")
  private Enseignant enseignant;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "admin_id", referencedColumnName = "id")
  private Admin admin;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cfd_id", referencedColumnName = "id")
  private CFD cfd;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "vDoyen_id", referencedColumnName = "id")
  private VDoyen vDoyen;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
