package com.proyectoinformatico.spring.springboot.servicios;

import java.util.List;
import java.util.Optional;

import com.proyectoinformatico.spring.springboot.models.Libros;

public interface I_ServicioLibro {
    List<Libros> obtenerTodos();

    Optional<Libros> obtenerPorId(long id);

    Libros guardar(Libros libro);

    void eliminarPorId(long id);

    String buscaLibrosPorTitulo(String titulo);

}
