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

import com.example.demo.models.VentasModel;
import com.example.demo.services.VentasService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    VentasService ventasService;

    @GetMapping()
    public ArrayList<VentasModel> obtenerVentas(){
        return ventasService.obtenerVentas();
    }

    @PostMapping()
    public VentasModel guardarVentas(@RequestBody VentasModel ventas){
        return this.ventasService.guardarVentas(ventas);
    }

    @GetMapping(path = "/{id}")
    public Optional<VentasModel> obtenerVentaPorId(@PathVariable("id_venta") Long id_venta){
        return this.ventasService.obtenerPorId(id_venta);
    }

    @GetMapping("/ventas/cantidad")
    public ArrayList<VentasModel> obtenerVentaPorCantidad(@RequestParam("cantidad") Integer cantidad){
        return this.ventasService.obtenerPorCantidad(cantidad);
    }

    //@GetMapping("/ventas/vendedor") //DUDA (CONSULTA CON UNA LLAVE FORÁNEA EN ESTA TABLA DE VENTAS)
    //public ArrayList<VentasModel> obtenerVentaPorIdUsu(@RequestParam("id_usuario") Long id_usuario){
        //return this.ventasService.obtenerPorIdUsu(id_usuario);
    //}

    @DeleteMapping (path = "/{id}")
    public String eliminarPorId (@PathVariable("id_venta") Long id_venta) {
        boolean ok = this.ventasService.eliminarVenta (id_venta) ;
        if (ok) {
            return "Se eliminó la venta con id" + id_venta;
        } else {
            return "No se pudo eliminar la venta con id" + id_venta;
        }
    }
}
