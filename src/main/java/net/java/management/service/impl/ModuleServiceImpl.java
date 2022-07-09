package net.java.management.service.impl;

import java.util.List;

import net.java.management.entity.Module;
import net.java.management.service.ModuleService;
import org.springframework.stereotype.Service;

import net.java.management.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {

    private ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        super();
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<Module> getAllModules() { return moduleRepository.findAll(); }

    @Override
    public Module saveModule(Module module) { return moduleRepository.save(module); }

    @Override
    public Module getModuleById(Long id) { return moduleRepository.findById(id).get(); }

    @Override
    public Module updateModule(Module module) { return moduleRepository.save(module); }

    @Override
    public void deleteModuleById(Long id) { moduleRepository.deleteById(id); }

}