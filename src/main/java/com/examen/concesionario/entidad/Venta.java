package com.examen.concesionario.entidad;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_venta;

    @NotBlank(message = "Debe de introducir la matricula")
    private String matricula;

    @NotBlank(message = "Debe de introducir la marca")
    private String marca;

    @NotBlank(message = "Debe de introducir el modelo")
    private String modelo;

    @NotBlank(message = "Debe de introducir el dni")
    private String dni;

    @NotBlank(message = "Debe de introducir el nombre")
    private String nombre;

    @NotBlank(message = "Debe de introducir el telefono")
    private String telefono;

    @Min(value = 0, message = "Debe de introducir una cantidad mayor que 0")
    private float precio;

    private Date fecha_venta;


    public Venta() {
    }

    public Venta(Long cod_venta, String matricula, String marca, String modelo, String dni, String nombre, String telefono, float precio, Date fecha_venta) {
        this.cod_venta = cod_venta;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.precio = precio;
        this.fecha_venta = fecha_venta;
    }

    public Long getCod_venta() {
        return this.cod_venta;
    }

    public void setCod_venta(Long cod_venta) {
        this.cod_venta = cod_venta;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha_venta() {
        return this.fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

}
