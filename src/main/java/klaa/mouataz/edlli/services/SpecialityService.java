package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.model.Speciality;

import java.util.List;

public interface SpecialityService {
    Speciality getById(Integer id);
    List<Speciality> getAll();
    Speciality save(Speciality speciality);
    void deleteById(Integer id);
    Admin updateSpeciality(Speciality speciality);
}
