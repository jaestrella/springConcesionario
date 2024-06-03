package com.examen.concesionario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examen.concesionario.entidad.Venta;
import com.examen.concesionario.servicio.VentaServicio;

@Controller
public class VentaControlador {

    @Autowired
    private VentaServicio servicio;

    @GetMapping({ "/", "" })
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("ventas", servicio.listarTodasLasVentas());
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistroVenta(Model modelo) {
        modelo.addAttribute("venta", new Venta());
        return "nuevo";
    }

    @PostMapping("/nuevo")
    public String registrarNuevaVenta(@Validated Venta venta, BindingResult bindingResult,
            RedirectAttributes redirect, Model modelo) {
                if(bindingResult.hasErrors()){
                    modelo.addAttribute("venta", venta);
                    return "nuevo";
                }
                servicio.guardarVenta(venta);
                redirect.addFlashAttribute("msgExito", "La venta ha sido creada");
                return "redirect:/";
    }

    @GetMapping("/{cod_venta}/editar")
    public String mostrarFormularioDeEditarVenta(@PathVariable Long cod_venta, Model modelo){
        
        modelo.addAttribute("venta", servicio.obtenerVentaPorId(cod_venta));
        return "nuevo";
    }

    @PostMapping("/{cod_venta}/editar")
    public String actualizarVenta(@PathVariable Long cod_venta, @Validated Venta venta,
            BindingResult bindingResult,
            RedirectAttributes redirect, Model modelo) {

        Venta ventaDB = servicio.obtenerVentaPorId(cod_venta);


        if (bindingResult.hasErrors()) {
            modelo.addAttribute("venta", venta);
            return "nuevo";
        }
        
        ventaDB.setMatricula(venta.getMatricula());
        ventaDB.setMarca(venta.getMarca());
        ventaDB.setModelo(venta.getModelo());
        ventaDB.setDni(venta.getDni());
        ventaDB.setNombre(venta.getNombre());
        ventaDB.setTelefono(venta.getTelefono());
        ventaDB.setPrecio(venta.getPrecio());
        ventaDB.setFecha_venta(venta.getFecha_venta());
       

        servicio.actualizarVenta(ventaDB);
        redirect.addFlashAttribute("msgExito", "La venta ha sido actualizada correctamente");
        return "redirect:/";
    }

    @PostMapping("/{cod_venta}/eliminar")
    public String eliminarVenta(@PathVariable Long cod_venta, RedirectAttributes redirect){
        servicio.eliminarVenta(cod_venta);
        redirect.addFlashAttribute("msgExito", "La venta ha sido eliminada correctamente");
        return "redirect:/";
    }


}
