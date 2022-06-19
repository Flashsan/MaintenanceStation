package com.it.academy.maintenancestation;

import com.it.academy.maintenancestation.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {
//    @Autowired
//    private MockMVC mockMvc;

//    @Test
//    private void testHomePage() throws Exception{
//        mockMvc.perform(get("/"))
//                .andExcept(status().isOk())
//                .andExpect(view().name("home"))
//                .andExcept(content().string(
//                        constrainString("Welcome to...")));
//    }
}
