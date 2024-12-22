package klaa.mouataz.edlli.controllers;

import jakarta.servlet.http.HttpServletRequest;
import klaa.mouataz.edlli.dto.AuthenticationRequest;
import klaa.mouataz.edlli.dto.AuthenticationResponse;
import klaa.mouataz.edlli.services.AuthenticationService;
import klaa.mouataz.edlli.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request, HttpServletRequest httpServletRequest
  ) {

    service.authenticate(request);
    return ResponseEntity.ok(service.authenticate(request));
  }


}
