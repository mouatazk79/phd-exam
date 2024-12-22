package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.Speciality;
import klaa.mouataz.edlli.repos.SpecialityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SpecialityService {
    private final SpecialityRepository specialityRepository;
    public Speciality getById(Integer id) {
        return specialityRepository.getSpecialityById(id);
    }

    public List<Speciality> getAll() {
        return specialityRepository.findAll();
    }

    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    public void deleteById(Integer id) {
          specialityRepository.deleteById(id);
    }


}
