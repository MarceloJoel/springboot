package com.proyectoinformatico.spring.springboot.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoinformatico.spring.springboot.models.Libros;
import com.proyectoinformatico.spring.springboot.repoLibros.RepoLibros;
import com.proyectoinformatico.spring.springboot.servicios.ServicioLibro;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/libros")

public class ControladorLibreria {

    private final ServicioLibro libroServicio; //final no puede cambiar de estado
    private final RepoLibros libroRepositorio;

    public ControladorLibreria(ServicioLibro libroServicio, RepoLibros libroRepositorio) {
        this.libroServicio = libroServicio;
        this.libroRepositorio = libroRepositorio;
    }

    @GetMapping("/{titulo}") //No hay setters
    public String DameLibro(@PathVariable String titulo) {
        return libroServicio.buscaLibro(titulo);
    }

    @GetMapping("/todos")
    public List<Libros>dimeTodos(){
        return libroRepositorio.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Libros>buscaId(@PathVariable long id){
        return libroRepositorio.buscaId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/clone")
    public String probarCLone(){
        Libros original = new Libros(1L,"Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 16));
        Libros copia = original.clone();

        return "Original: " + original.toString() +
                "   | Copia: " + copia.toString(); 
    }
    
    

}
