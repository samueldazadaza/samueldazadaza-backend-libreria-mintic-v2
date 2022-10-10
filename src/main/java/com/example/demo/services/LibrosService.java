package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.LibrosModel;
import com.example.demo.repositories.LibrosRepository;

@Service
public class LibrosService {
    @Autowired
    LibrosRepository librosRepository;

    public ArrayList<LibrosModel> obtenerLibros(){
        return(ArrayList<LibrosModel>) librosRepository.findAll();
    }

    public LibrosModel guardarLibros(LibrosModel libros){
        return librosRepository.save(libros);
    }

    public Optional<LibrosModel> obtenerPorId(Long id_libro){
        return librosRepository.findById(id_libro);
    }

    public ArrayList<LibrosModel> obtenerPorTitulo(String titulo){
        return librosRepository.findByTitulo(titulo);
    }

    public ArrayList<LibrosModel> obtenerPorAutor(String autor){
        return librosRepository.findByAutor(autor);
    }

    public boolean eliminarLibro(Long id_libro){
        try{
            librosRepository.deleteById(id_libro);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
