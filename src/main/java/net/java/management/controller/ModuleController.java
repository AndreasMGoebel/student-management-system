package net.java.management.controller;

import net.java.management.entity.Module;
import net.java.management.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ModuleController {

    private ModuleService moduleService;


    public ModuleController(ModuleService moduleService) {
        super();
        this.moduleService = moduleService;
    }

    // handler method to handle list modules and return mode and view
    @GetMapping("/modules")
    public String listModules(Model model) {
        model.addAttribute("modules", moduleService.getAllModules());
        return "modules";
    }

    @GetMapping("/modules/new")
    public String createModuleForm(Model model) {

        // create module object to hold module form data
        Module module = new Module();
        model.addAttribute("module", module);
        return "create_module";

    }

    @PostMapping("/modules")
    public String saveModule(@ModelAttribute("module") Module module) {
        moduleService.saveModule(module);
        return "redirect:/modules";
    }

    @GetMapping("/modules/edit/{id}")
    public String editModuleForm(@PathVariable Long id, Model model) {
        model.addAttribute("module", moduleService.getModuleById(id));
        return "edit_module";
    }

    @PostMapping("/modules/{id}")
    public String updateModules(@PathVariable Long id,
                                @ModelAttribute("module") Module module,
                                Model model) {

        // get module from database by id
        Module existingModule = moduleService.getModuleById(id);
        existingModule.setId(id);
        existingModule.setmoduleName(module.getmoduleName());
        existingModule.setgrade(module.getgrade());

        // save updated module object
        moduleService.updateModule(existingModule);
        return "redirect:/modules";
    }

    // handler method to handle delete module request

    @GetMapping("/modules/{id}")
    public String deleteModule(@PathVariable Long id) {
        moduleService.deleteModuleById(id);
        return "redirect:/modules";
    }


}