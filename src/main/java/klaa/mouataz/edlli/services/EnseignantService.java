package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Enseignant;
import klaa.mouataz.edlli.repos.EnseignantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EnseignantService {
    private final EnseignantRepository enseignantRepository;
    private final UserService userService;

    public Enseignant getById(Integer id) {
        return enseignantRepository.findEnseignantById(id);
    }

    public List<Enseignant> getAll() {
        return enseignantRepository.findAll();
    }

    public Enseignant save(StaffRequest staffRequest) {
        userService.save(staffRequest.getUser());
        Enseignant enseignant=Enseignant.builder()
                .uid(staffRequest.getUser().getId())
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .gender(staffRequest.getGender())
                .dob(staffRequest.getDob())
                .number(staffRequest.getNumber())
                .user(staffRequest.getUser())
                .build();

        return enseignantRepository.save(enseignant);
    }

    public void deleteById(Integer id) {
     enseignantRepository.deleteById(id);
    }

    public Enseignant updateEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }
}
