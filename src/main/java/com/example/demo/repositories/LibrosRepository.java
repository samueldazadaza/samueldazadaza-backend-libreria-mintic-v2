package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.LibrosModel;

@Repository
public interface LibrosRepository extends CrudRepository<LibrosModel, Long> {
    public abstract ArrayList<LibrosModel> findByAutor(String autor);
    public abstract ArrayList<LibrosModel> findByTitulo(String titulo);
}
