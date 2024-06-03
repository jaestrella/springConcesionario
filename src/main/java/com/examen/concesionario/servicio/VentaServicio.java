package com.examen.concesionario.servicio;

import java.util.List;

import com.examen.concesionario.entidad.Venta;

public interface VentaServicio {

    public List<Venta> listarTodasLasVentas();
    
    public Venta guardarVenta(Venta venta);

    public Venta obtenerVentaPorId(Long cod_venta);

    public Venta actualizarVenta(Venta venta);

    public void eliminarVenta(Long cod_venta);
}
