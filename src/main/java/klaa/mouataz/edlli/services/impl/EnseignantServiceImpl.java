package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Enseignant;
import klaa.mouataz.edlli.repos.EnseignantRepository;
import klaa.mouataz.edlli.services.EnseignantService;
import klaa.mouataz.edlli.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EnseignantServiceImpl implements EnseignantService {
    private final EnseignantRepository enseignantRepository;
    private final UserService userService;

    @Override
    public Enseignant getById(Integer id) {
        return enseignantRepository.findEnseignantById(id);
    }

    @Override
    public List<Enseignant> getAll() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant save(StaffRequest staffRequest) {
        userService.save(staffRequest.getUser());
        Enseignant enseignant=Enseignant.builder()
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .gender(staffRequest.getGender())
                .dob(staffRequest.getDob())
                .number(staffRequest.getNumber())
                .user(staffRequest.getUser())
                .build();

        return enseignantRepository.save(enseignant);
    }

    @Override
    public void deleteById(Integer id) {
     enseignantRepository.deleteById(id);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }
}
