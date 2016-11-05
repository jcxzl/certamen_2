package com.example.jc.tarea2.Models;

/**
 * Created by Jc on 03-11-2016.
 */

public class Git {
    private String nombre, descripcion, actualizacion;

    public Git(String nombre, String descripcion, String actualizacion){
        this.setActualizacion(actualizacion);
        this.setDescripcion(descripcion);
        this.setNombre(nombre);
    }

    public String getActualizacion() {
        return actualizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setActualizacion(String actualizacion) {
        this.actualizacion = actualizacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
