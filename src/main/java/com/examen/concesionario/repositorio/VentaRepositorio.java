package com.examen.concesionario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.concesionario.entidad.Venta;

public interface VentaRepositorio extends JpaRepository<Venta,Long>{
    
}
