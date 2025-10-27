package com.proyectoinformatico.spring.springboot.repoLibros;

import java.util.List;
import java.util.Optional;

import com.proyectoinformatico.spring.springboot.models.Libros;

public interface I_RepoLibros {
    List<Libros> findAll();

    Optional<Libros> findById(long id);

    void save(Libros libro);

    void deleteById(long id);

}
