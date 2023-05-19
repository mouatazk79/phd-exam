package klaa.mouataz.edlli.controllers;
import klaa.mouataz.edlli.model.Module;
import klaa.mouataz.edlli.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/modules")
public class ModuleController {
    private final ModuleService moduleService;
    @GetMapping
    public List<Module> getAllModules(){
        return moduleService.getAll();
    }
    @GetMapping("/student/{id}")
    public Module getModule(@PathVariable("id")Integer id){
        return moduleService.getById(id);
    }
    @PostMapping("/add")
    public Module addModule(@RequestBody Module module){
        return moduleService.save(module);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){

        moduleService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Module updateVDoyen(@PathVariable("id") Integer id, @RequestBody Module module){
        module.setId(id);
        return moduleService.updateModule(module);
    }
}
