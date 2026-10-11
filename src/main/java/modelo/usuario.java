/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santi
 */
public abstract class usuario {
    private String nombre;
    private String celular;
    private String correo;
    private String id;

    public usuario(String nombre, String celular, String correo, String id) {
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public abstract double obtenerDescuento();

    @Override
    public String toString() {
        return "usuario{" + "nombre=" + nombre + ", celular=" + celular + ", correo=" + correo + ", id=" + id + '}';
    }
    
    
    
    
}
