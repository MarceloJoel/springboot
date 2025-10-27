package com.proyectoinformatico.spring.springboot.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoinformatico.spring.springboot.models.Libros;
import com.proyectoinformatico.spring.springboot.repoLibros.RepoLibros;
import com.proyectoinformatico.spring.springboot.servicios.I_ServicioLibro;
import com.proyectoinformatico.spring.springboot.servicios.ServicioLibro;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/libros")

public class ControladorLibreria {

    // private final ServicioLibro libroServicio; //final no puede cambiar de estado
    // private final RepoLibros libroRepositorio;

    private final I_ServicioLibro i_servicio;

    public ControladorLibreria(I_ServicioLibro i_servicio) {
        this.i_servicio = i_servicio;
    }

    @GetMapping("/todos")
    public List<Libros> listar() {
        return i_servicio.obtenerTodos();
    }

    // @GetMapping("/{titulo}") //No hay setters
    // public String DameLibro(@PathVariable String titulo) {
    // return libroServicio.buscaLibro(titulo);
    // }

    // @GetMapping("/todos")
    // public List<Libros>dimeTodos(){
    // return libroRepositorio.findAll();
    // }

    // @GetMapping("/id/{id}")
    // public ResponseEntity<Libros>buscaId(@PathVariable long id){
    // return libroRepositorio.buscaId(id)
    // .map(ResponseEntity::ok)
    // .orElse(ResponseEntity.notFound().build());
    // }

    @GetMapping("/clone")
    public String probarCLone() {
        Libros original = new Libros(1L, "Miguel de Cervantes", "El Quijote",
                LocalDate.of(1605, 1, 16));
        Libros copia = original.clone();

        return "Original: " + original.toString() +
                " | Copia: " + copia.toString();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> obtenerPorId(@PathVariable long id) {
        Optional<Libros> libro = i_servicio.obtenerPorId(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libros> crear(@RequestBody Libros libro) {
        i_servicio.guardar(libro);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        i_servicio.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
