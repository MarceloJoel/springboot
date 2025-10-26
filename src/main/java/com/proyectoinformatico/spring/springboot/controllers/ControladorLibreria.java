package com.proyectoinformatico.spring.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoinformatico.spring.springboot.models.ServicioLibro;

@RestController
@RequestMapping("/api/libros")

public class ControladorLibreria {

    private final ServicioLibro libroServicio; //final no puede cambiar de estado

    public ControladorLibreria(ServicioLibro libroServicio) {
        this.libroServicio = libroServicio;
    }

    @GetMapping("/{titulo}") //No hay setters
    public String DameLibro(@PathVariable String titulo) {
        return libroServicio.buscaLibro(titulo);
    }

}
