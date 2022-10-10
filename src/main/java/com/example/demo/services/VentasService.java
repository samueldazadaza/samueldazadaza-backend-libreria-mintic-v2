package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.VentasModel;
import com.example.demo.repositories.VentasRepository;

@Service
public class VentasService {
    @Autowired
    VentasRepository ventasRepository;

    public ArrayList<VentasModel> obtenerVentas(){
        return(ArrayList<VentasModel>) ventasRepository.findAll();
    }

    public VentasModel guardarVentas(VentasModel ventas){
        return ventasRepository.save(ventas);
    }

    public Optional<VentasModel> obtenerPorId(Long id_venta){
        return ventasRepository.findById(id_venta);
    }

    public ArrayList<VentasModel> obtenerPorCantidad(Integer cantidad){
        return ventasRepository.findByCantidad(cantidad);
    }

//  public ArrayList<VentasModel> obtenerPorIdUsu(Long id_usuario){
//      return ventasRepository.findByIdUsu(id_usuario);
//    }

    public boolean eliminarVenta(Long id_venta){
        try{
            ventasRepository.deleteById(id_venta);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
