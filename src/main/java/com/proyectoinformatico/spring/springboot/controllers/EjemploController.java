package com.proyectoinformatico.spring.springboot.controllers;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectoinformatico.spring.springboot.models.Empleados;


@Controller
public class EjemploController {
    @GetMapping("/detalles_info")

    public String info(Model model) {

        Empleados empleado1 = new Empleados("Juan","Rodriguez", "Calle 123", "Gerente",
        35, 123456789,001);
        model.addAttribute("Empleado", empleado1);
        return "detalles_info";

    }

}
