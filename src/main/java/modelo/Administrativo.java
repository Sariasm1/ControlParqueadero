/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santi
 */
public class Administrativo extends Usuario {
    private String dependencia;
    private String cargo;

    public Administrativo(String dependencia, String cargo, String nombre, String celular, String correo, String id) {
        super(nombre, celular, correo, id);
        this.dependencia = dependencia;
        this.cargo = cargo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public double obtenerDescuento() {
        return 0.3;
    }

    @Override
    public String toString() {
        return "Administrativo{" + "dependencia=" + dependencia + ", cargo=" + cargo + '}';
    }
}
