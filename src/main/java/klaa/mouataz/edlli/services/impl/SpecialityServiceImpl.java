package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.model.Speciality;
import klaa.mouataz.edlli.repos.SpecialityRepository;
import klaa.mouataz.edlli.services.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;
    @Override
    public Speciality getById(Integer id) {
        return specialityRepository.getSpecialityById(id);
    }

    @Override
    public List<Speciality> getAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void deleteById(Integer id) {
          specialityRepository.deleteById(id);
    }

    @Override
    public Admin updateSpeciality(Speciality speciality) {
        return null;
    }
}
