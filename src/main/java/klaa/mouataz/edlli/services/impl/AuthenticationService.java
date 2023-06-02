package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.dto.AuthenticationRequest;
import klaa.mouataz.edlli.dto.AuthenticationResponse;
import klaa.mouataz.edlli.dto.RegisterRequest;
import klaa.mouataz.edlli.enumerations.Gender;
import klaa.mouataz.edlli.model.*;
import klaa.mouataz.edlli.repos.*;
import klaa.mouataz.edlli.security.JwtService;
import klaa.mouataz.edlli.security.token.Token;
import klaa.mouataz.edlli.security.token.TokenRepository;
import klaa.mouataz.edlli.enumerations.TokenType;
import klaa.mouataz.edlli.enumerations.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final CFDRepository cfdRepository;
  private final AdminRepository adminRepository;
  private final StudentRepository studentRepository;
  private final EnseignantRepository enseignantRepository;
  private final VDoyenRepository vDoyenRepository;

  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(savedUser, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    String fName;
    String lName;
    LocalDate dob;
    Gender gender;
    String number;
    if(user.getRole().equals(Role.ADMIN)){
     Admin admin= adminRepository.findByUser_Email(user.getEmail());

    } else if (user.getRole().equals(Role.CDG)) {
      CFD cfd=cfdRepository.findByUser_Email(user.getEmail());
    } else if (user.getRole().equals(Role.STUDENT)) {
      Student student=studentRepository.findByUser_Email(user.getEmail());
    } else if (user.getRole().equals(Role.ENSEIGNANT)) {
      Enseignant enseignant=enseignantRepository.findByUser_Email(user.getEmail());
    } else if (user.getRole().equals(Role.VCDOYEN)) {
      VDoyen vDoyen=vDoyenRepository.findByUser_Email(user.getEmail());
    }
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
            .role(user.getRole())
            .id(user.getId())
        .token(jwtToken)
        .build();
  }

  private void saveUserToken(User user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
