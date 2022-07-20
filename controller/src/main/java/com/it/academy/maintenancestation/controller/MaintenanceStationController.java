package com.it.academy.maintenancestation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MaintenanceStationController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
public class MaintenanceStationController {

    /**
     * Constant(MaintenanceStationController)
     */
    public static final String INDEX = "index";

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String listAdministrators(Model model) {
        return INDEX;
    }


}
