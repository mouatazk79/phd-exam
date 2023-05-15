package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.model.Speciality;
import klaa.mouataz.edlli.services.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/specialities")
public class SpecialityController {
    private final SpecialityService specialityService;
    @GetMapping
    public List<Speciality> getSpecialities(){
        return specialityService.getAll();
    }
    @GetMapping("/speciality/{id}")
    public Speciality getSpeciality(@PathVariable("id")Integer id){
        return specialityService.getById(id);
    }
    @PostMapping("/add")
    public Speciality addSpeciality(@RequestBody Speciality speciality){
        return specialityService.save(speciality);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteSpeciality(@PathVariable("id")Integer id){
        specialityService.deleteById(id);
    }

}

