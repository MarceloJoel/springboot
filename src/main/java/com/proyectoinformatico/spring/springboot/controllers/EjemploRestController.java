package com.proyectoinformatico.spring.springboot.controllers;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoinformatico.spring.springboot.models.Empleados;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")

public class EjemploRestController {

    //@RequestMapping(path = "/detalles_info2", method = RequestMethod.GET)
    @GetMapping("/detalles_info2")
    
    public Map<String, Object> detalles_info2() {
        Empleados empleado1 = new Empleados("Juan","Rodriguez", "Calle 123", "Gerente",
                                        35, 123456789,001);
        
        Map<String, Object> respuesta = new HashMap<>(); 
        respuesta.put("Empleado", "Datos empleado");
        respuesta.put("Informacion", empleado1);
        

        return respuesta;
        
    }

}
