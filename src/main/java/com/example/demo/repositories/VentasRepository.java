package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.VentasModel;

@Repository
public interface VentasRepository extends CrudRepository<VentasModel, Long> {
    public abstract ArrayList<VentasModel> findByCantidad(Integer cantidad);
//  public abstract ArrayList<VentasModel> findByIdUsu(Long id_usuario); //DUDA (LLAVE FORANEA)
}
