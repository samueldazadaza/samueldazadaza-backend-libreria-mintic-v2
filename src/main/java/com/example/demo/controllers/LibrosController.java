package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LibrosModel;
import com.example.demo.services.LibrosService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/libros")
public class LibrosController {
    @Autowired
    LibrosService librosService;

    @GetMapping()
    public ArrayList<LibrosModel> obtenerLibros() {
        return librosService.obtenerLibros();
    }

    @PostMapping()
    public LibrosModel guardarLibro(@RequestBody LibrosModel id_libro) {
        return this.librosService.guardarLibros(id_libro);
    }

    @GetMapping(path = "/{id_libro}")
    public Optional<LibrosModel> obtenerLibroPorId(@PathVariable("id_libro") Long id_libro) {
        return this.librosService.obtenerPorId(id_libro);
    }

    @GetMapping("/titulo")
    public ArrayList<LibrosModel> obtenerLibroPorTitulo(@RequestParam("titulo") String titulo) {
        return this.librosService.obtenerPorTitulo(titulo);
    }

    @GetMapping("/autor")
    public ArrayList<LibrosModel> obtenerLibroPorAutor(@RequestParam("autor") String autor) {
        return this.librosService.obtenerPorAutor(autor);
    }

    @DeleteMapping(path = "/{id_libro}")
    public String eliminarPorId(@PathVariable("id_libro") Long id_libro) {
        boolean ok = this.librosService.eliminarLibro(id_libro);
        if (ok) {
            return "Se eliminó el libro con id👉: " + id_libro;
        } else {
            return "No se pudo eliminar el libro con id👉: " + id_libro;
        }
    }
}
