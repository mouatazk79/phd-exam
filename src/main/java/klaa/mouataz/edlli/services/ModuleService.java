package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.Module;
import klaa.mouataz.edlli.repos.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ModuleService{
    private final ModuleRepository moduleRepository;
    public Module getById(Integer id) {
        return moduleRepository.findModuleById(id);
    }

    public List<Module> getAll() {
        return moduleRepository.findAll();
    }

    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    public void deleteById(Integer id) {
      moduleRepository.deleteById(id);
    }

}
