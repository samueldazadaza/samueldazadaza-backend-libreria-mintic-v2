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

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id_usuario") Long id_usuario){
        return this.usuarioService.obtenerPorId(id_usuario);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorEmail(@RequestParam("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }

    @DeleteMapping (path = "/{id}")
    public String eliminarPorId (@PathVariable("id_usuario") Long id_usuario) {
        boolean ok = this.usuarioService.eliminarUsuario (id_usuario) ;
        if (ok) {
            return "Se eliminó el usuario con id" + id_usuario;
        } else {
            return "No se pudo eliminar el usuario con id" + id_usuario;
        }
    }
}
