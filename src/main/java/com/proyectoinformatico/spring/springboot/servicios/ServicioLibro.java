package com.proyectoinformatico.spring.springboot.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoinformatico.spring.springboot.models.Libros;
import com.proyectoinformatico.spring.springboot.repoLibros.I_RepoLibros;

@Service
public class ServicioLibro implements I_ServicioLibro {

    // public String buscaLibro(String titulo) {
    // if ("El quijote".equalsIgnoreCase(titulo)) {
    // return "Libro encontrado!";
    // } else {
    // return "Libro no encontrado";
    // }
    // }

    private final I_RepoLibros i_repo;

    @Autowired // Aqui lo conecta de forma automatica !Lo crea po si solo¡
    public ServicioLibro(I_RepoLibros i_repo) {
        this.i_repo = i_repo;
    }

    @Override
    public List<Libros> obtenerTodos() {
        return i_repo.findAll();
    }

    @Override
    public Optional<Libros> obtenerPorId(long id) {
        return i_repo.findById(id);
    }

    @Override
    public Libros guardar(Libros libro) {
        i_repo.save(libro);
        return libro;
    }

    @Override
    public void eliminarPorId(long id) {
        i_repo.deleteById(id);
    }

    @Override
    public String buscaLibrosPorTitulo(String titulo) {
        boolean encontrado = i_repo.findAll().stream()
                .anyMatch(libros -> libros.getTitulo() != null && libros.getTitulo().equalsIgnoreCase(titulo));
        return encontrado ? "Libro encontrado!!!" : "Libro no encontrado :C";
    }

}
