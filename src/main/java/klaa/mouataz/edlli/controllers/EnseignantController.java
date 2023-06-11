package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Enseignant;
import klaa.mouataz.edlli.model.Message;
import klaa.mouataz.edlli.model.Module;
import klaa.mouataz.edlli.repos.EnseignantRepository;
import klaa.mouataz.edlli.services.EnseignantService;
import klaa.mouataz.edlli.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enseignants")
public class EnseignantController {
    private final EnseignantService enseignantService;
    private final MessageService messageService;
    private final EnseignantRepository enseignantRepository;

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
    @PatchMapping("/{id}")
    public Enseignant updateEnseignant(@PathVariable("id") Integer id,@RequestBody Enseignant enseignant){
        enseignant.setId(id);
        return enseignantService.updateEnseignant(enseignant);
    }
    @PatchMapping("/addmodule/{id}")
    public Enseignant addModuleEnseignant(@PathVariable("id") Integer id, @RequestBody List<Module> modules){
        Enseignant enseignant=enseignantService.getById(id);
        enseignant.getModules().addAll(modules);
        return enseignantService.updateEnseignant(enseignant);
    }
    @PatchMapping("/addmodulelist/{id}")
    public Enseignant addModuleListEnseignant(@PathVariable("id") Integer id, @RequestBody String modules){
        Enseignant enseignant=enseignantService.getById(id);
        enseignant.setListModules(modules);
        return enseignantService.updateEnseignant(enseignant);
    }
    @PatchMapping("/addmessage/{id}")
    public Enseignant addMessageEnseignant(@PathVariable("id") Integer id, @RequestBody Message message){
        message.setEnseignant(enseignantService.getById(id));
        messageService.save(message);
        Enseignant enseignant=enseignantService.getById(id);
        enseignant.getMessages().add(message);
        return enseignantService.updateEnseignant(enseignant);

    }
    @GetMapping("/enseignant/byuser/{id}")
    public Enseignant getEnseignantByUserid(@PathVariable("id")Integer id){
        return enseignantRepository.findByUid(id);
    }

}
