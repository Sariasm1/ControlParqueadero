/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import utilidades.*;
import java.util.ArrayList;


/**
 *
 * @author santi
 */
public class Parqueadero {
    private final ArrayList<Tiquete> listaTiquetes;
    private ArrayList<Espacio> espacios;
    private String nombre;
    private double tarifaPorHora;
    private final int espaciosTotales; 

    public Parqueadero(String nombre, double tarifaPorHora, int espaciosTotales) {
        this.nombre = nombre;
        this.tarifaPorHora = tarifaPorHora;
        this.espaciosTotales = espaciosTotales;
        this.listaTiquetes = new ArrayList<>();
        this.espacios = new ArrayList<>();
        
        for (int i = 1; i <= this.espaciosTotales; i++) {
            this.espacios.add(new Espacio("A-" + i));
        }
    }
    
    public Tiquete crearTiquete(int id, Usuario u, Vehiculo v) {
        Tiquete t = new Tiquete(id, u, v);
        this.listaTiquetes.add(t);
        return t;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public ArrayList<Tiquete> getListaTiquetes() {
        return listaTiquetes;
    }
    
    public void addListaTiquetes(Tiquete t){
        this.listaTiquetes.add(t);
    }
    
    public void removeListaTiquetes(Tiquete t){
        this.listaTiquetes.remove(t);
    }
    
    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
    
    public ArrayList<Espacio> getEspacios() {
         return espacios;
    }

    public Espacio obtenerEspacioDisponible() {
        for (Espacio e : espacios) {
            if (e.getEstado() == EstadoEspacio.DISPONIBLE) {
                return e;
            }
        }
        return null;
    }

}
