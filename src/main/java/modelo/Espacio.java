/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;
import utilidades.*;

/**
 *
 * @author santi
 */

public class Espacio {
    private String codigo;
    private EstadoEspacio estado;

    public Espacio() {
        this.estado = EstadoEspacio.DISPONIBLE;
    }

    public Espacio(String codigo) {
        this.codigo = codigo;
        this.estado = EstadoEspacio.DISPONIBLE;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public EstadoEspacio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEspacio estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return codigo + " (" + estado + ")";
    }
}