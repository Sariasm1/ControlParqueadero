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
    private final ArrayList<Tiquete> listaTiquetes;
    private final ArrayList<String> espaciosDisponibles;
    private ArrayList<String> espaciosOcupados;
    private String nombre;
    private double tarifaPorHora;
    private final int espaciosTotales = 2; 

    public Parqueadero(String nombre, double tarifaPorHora) {
        this.nombre = nombre;
        this.tarifaPorHora = tarifaPorHora;
        this.listaTiquetes = new ArrayList<>();
        this.espaciosOcupados = new ArrayList<>();
        this.espaciosDisponibles = new ArrayList<>();
        
        for (int i = 1; i <= espaciosTotales; i++) {
            this.espaciosDisponibles.add("A-" + i);
        }
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

    public ArrayList<String> getEspaciosDisponibles() {
        return espaciosDisponibles;
    }
    
    public void addEspaciosDisponibles(String e){
        this.espaciosDisponibles.add(e);
    }
    
    public String removeEspacioDisponible(int n){
        return this.espaciosDisponibles.remove(n);
    }

    public ArrayList<String> getEspaciosOcupados() {
        return espaciosOcupados;
    }
    
    public void addEspaciosOcupados(String e){
        this.espaciosOcupados.add(e);
    }
    
    public void removeEspaciosOcupados(String e){
        this.espaciosOcupados.remove(e);
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
}
