package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Enseignant;
import klaa.mouataz.edlli.services.EnseignantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enseignants")
public class EnseignantController {
    private final EnseignantService enseignantService;
    @GetMapping
    public List<Enseignant> getEnseignants(){
        return enseignantService.getAll();
    }
    @GetMapping("/enseignant/{id}")
    public Enseignant getEnseignant(@PathVariable("id")Integer id){
        return enseignantService.getById(id);
    }
    @PostMapping("/add")
    public Enseignant addEnseignant(@RequestBody StaffRequest staffRequest){
        return enseignantService.save(staffRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEnseignant(@PathVariable("id")Integer id){
        enseignantService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Enseignant updateEnseignant(@PathVariable("id") Integer id,@RequestBody Enseignant enseignant){
        enseignant.setId(id);
        return enseignantService.updateEnseignant(enseignant);
    }

}
