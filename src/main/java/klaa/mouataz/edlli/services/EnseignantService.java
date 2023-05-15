package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Enseignant;

import java.util.List;

public interface EnseignantService {
    Enseignant getById(Integer id);
    List<Enseignant> getAll();
    Enseignant save(StaffRequest staffRequest);
    void deleteById(Integer id);
    Enseignant updateEnseignant(Enseignant enseignant);
}
