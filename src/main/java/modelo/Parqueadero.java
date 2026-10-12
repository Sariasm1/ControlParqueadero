/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class Parqueadero {
    private ArrayList<Tiquete> listaTiquetes;
    private ArrayList<String> espaciosOcupados;
    private String nombre;
    private double tarifaPorHora;
    private int espaciosDisponibles;
    private int espaciosTotales;

    public Parqueadero(String nombre, double tarifaPorHora, int espaciosTotales) {
        this.nombre = nombre;
        this.tarifaPorHora = tarifaPorHora;
        this.espaciosTotales = espaciosTotales;
        this.espaciosDisponibles = espaciosTotales;
        this.listaTiquetes = new ArrayList<>();
        this.espaciosOcupados = new ArrayList<>();
    }

    public void setEspaciosOcupados(ArrayList<String> espaciosOcupados) {
        this.espaciosOcupados = espaciosOcupados;
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

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getEspaciosDisponibles() {
        return espaciosDisponibles;
    }

    public void setEspaciosDisponibles(int espaciosDisponibles) {
        this.espaciosDisponibles = espaciosDisponibles;
    }

    public int getEspaciosTotales() {
        return espaciosTotales;
    }

    public void setEspaciosTotales(int espaciosTotales) {
        this.espaciosTotales = espaciosTotales;
    }
    
    public void registrarTiquete(Tiquete t){
        listaTiquetes.add(t);
    }
    
    public void removerTiquete(Tiquete t){
    if (listaTiquetes.remove(t)) {
        System.out.println("Tiquete con ID "+ t.getIdTiquete()+ " removido con exito.");
    } else {
        System.out.println("El Tiquete con ID " + t.getIdTiquete() + " no se encuentra actualmente en el parqueadero.");
    }
 }
    
   public void removerTiquete(int idTiquete){
     for (Tiquete t : listaTiquetes) {
        if (t.getIdTiquete() == idTiquete) { 
            listaTiquetes.remove(t);
            System.out.println("Tiquete con ID "+ t.getIdTiquete()+ " removido con exito.");
            return;
        }
    }
    System.out.println("No se encontró ningún Tiquete con ID "+ idTiquete);
   }
    
    
    
    
}
