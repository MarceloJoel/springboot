package com.proyectoinformatico.spring.springboot.util;

import org.springframework.stereotype.Component;

import com.proyectoinformatico.spring.springboot.models.Libros;

@Component
public class ValidaLibros {
    public Libros libro;

    public boolean tituloValido() {
        return libro.getTitulo() != null && !Boolean.parseBoolean(libro.getTitulo());
    }
}
