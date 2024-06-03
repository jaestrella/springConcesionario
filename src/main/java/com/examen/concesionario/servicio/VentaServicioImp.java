package com.examen.concesionario.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.concesionario.entidad.Venta;
import com.examen.concesionario.repositorio.VentaRepositorio;

@Service
public class VentaServicioImp implements VentaServicio {

    @Autowired
    private VentaRepositorio repositorio;

    @Override
    public List<Venta> listarTodasLasVentas() {
        return repositorio.findAll();
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return repositorio.save(venta);
    }

    @Override
    public Venta obtenerVentaPorId(Long cod_venta) {
        return repositorio.getReferenceById(cod_venta);
    }

    @Override
    public Venta actualizarVenta(Venta venta) {
        return repositorio.save(venta);
    }

    @Override
    public void eliminarVenta(Long cod_venta) {
        repositorio.deleteById(cod_venta);
    }

}
