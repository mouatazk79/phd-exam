package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.model.Reclamation;
import klaa.mouataz.edlli.repos.ReclamationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reclamations")
public class ReclamationController {
    private final ReclamationRepository reclamationRepository;
    @GetMapping
    public List<Reclamation> getReclamations(){
        return reclamationRepository.findAll();
    }
    @PostMapping("/add")
    public Reclamation addReclamations(@RequestBody Reclamation reclamation){
        return reclamationRepository.save(reclamation);
    }
    @GetMapping("/get/{id}")
    public List<Reclamation> getReclamationsByUUID(@PathVariable("id")UUID id){
        return reclamationRepository.findAllByUuid(id);
    }
}
