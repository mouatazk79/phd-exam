package klaa.mouataz.edlli.services;


import klaa.mouataz.edlli.model.Module;

import java.util.List;

public interface ModuleService {
    Module getById(Integer id);
    List<Module> getAll();
    Module save(Module module);
    void deleteById(Integer id);
    Module updateModule(Module module);
}
