package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.model.Module;
import klaa.mouataz.edlli.repos.ModuleRepository;
import klaa.mouataz.edlli.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    @Override
    public Module getById(Integer id) {
        return moduleRepository.findModuleById(id);
    }

    @Override
    public List<Module> getAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public void deleteById(Integer id) {
      moduleRepository.deleteById(id);
    }

    @Override
    public Module updateModule(Module module) {
        return null;
    }
}
