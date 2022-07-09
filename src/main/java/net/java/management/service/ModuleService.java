package net.java.management.service;

import net.java.management.entity.Module;

import java.util.List;

public interface ModuleService {
    List<Module> getAllModules();

    Module saveModule(Module module);

    Module getModuleById(Long id);

    Module updateModule(Module module);

    void deleteModuleById(Long id);
}