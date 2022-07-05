package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

}
//    @RequestMapping("/listAdministrators")
//    public String listAdministrators(Model model) {
//        model.addAttribute("administrator", administratorService.listAllAdministrators());
//        return "administrator";
//    }

//    @PostMapping("/newAdministrator")
//    public String newAdministrator(Administrator administrator) {
//        administratorService.newAdministrator(administrator);
//        return "redirect:/administrator/list_administrator";
//    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveAdministrator(@ModelAttribute("administrator") Administrator administrator) {
//        administratorService.saveAdministrator(administrator);
//        return "redirect:/";
//    }

//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditAdministratorPage(@PathVariable(name = "id") int id) {
//        ModelAndView modelAndView = new ModelAndView("edit_administrator");
//        Administrator administrator = administratorService.findAdministratorById(id);
//        modelAndView.addObject("administrator", administrator);
//        return modelAndView;
//    }
//
//    @RequestMapping("delete/{id}")
//    public String deleteAdministrator(@PathVariable(name = "id") int id) {
//        administratorService.deleteAdministratorById(id);
//        return "redirect:/";
//    }



