/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author santi
 */
public class Parqueadero {
    private ArrayList<Tiquete> listaTiquetes;
    private ArrayList<String> espaciosDisponibles;
    private ArrayList<String> espaciosOcupados;
    private String nombre;
    private double tarifaPorHora;
    private static final int espaciosTotales = 1; 
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

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
    
    public void imprimirTiquete(double horasTiquete, Tiquete t){
            double costoBase = horasTiquete * tarifaPorHora;
            double descuento = costoBase * t.getUsuario().obtenerDescuento();
            System.out.println("Usuario: "+t.getUsuario().getNombre());
            System.out.println("ID: "+t.getIdTiquete());
            //System.out.println("Vehiculo: "+t.getVehiculo().getPlaca());
            System.out.println("Estado: "+t.getEstado());
            System.out.println("Espacio ocupado: "+(t.getEspacioOcupado() != null ? t.getEspacioOcupado() : "N/A"));
            System.out.println("Hora de ingreso: "+ t.getFechaHoraEntrada().format(formato));
            System.out.println("Hora de salida: " + (t.getFechaHoraSalida() != null ? t.getFechaHoraSalida().format(formato) : "N/A"));
            System.out.println("Descuento: " + descuento + " (" + t.getUsuario().obtenerDescuento() * 100 + "%)");
            System.out.println("-----------");
            System.out.println("Total: "+ costoBase + " COP");
            System.out.println("Descuento aplicado: " + (costoBase - descuento));
    }

    
    public void removerTiquete(Tiquete t){
    if (listaTiquetes.remove(t)) {
        System.out.println("Tiquete con ID "+ t.getIdTiquete()+ " removido con exito.");
    } else {
        System.out.println("El Tiquete con ID " + t.getIdTiquete() + " no se encuentra actualmente en el parqueadero.");
    }
 }
    
    public void removerTiquete(int idTiquete){
      Tiquete t = buscarTiquete(idTiquete);
      if(t != null){
         listaTiquetes.remove(t);
         System.out.println("Tiquete con ID "+ t.getIdTiquete()+ " removido con exito.");
         return;
      }
      System.out.println("No se encontró ningún Tiquete con ID "+ idTiquete);
    }
    
    
    public Tiquete buscarTiquete(int idTiquete){
        for (Tiquete t : listaTiquetes) {
         if (t.getIdTiquete() == idTiquete) { 
             return t;
            }
         }
     return null;
    }
    
    public Tiquete buscarTiquete(String idPersona){
     for (Tiquete t : listaTiquetes) {
         if (t.getUsuario().getId().matches(idPersona)) { 
             return t;
            }
         }
     return null;
    }
   
    public void mostrarInfoTiquete(int idTiquete){
        Tiquete t = buscarTiquete(idTiquete);
        if(t != null){
            System.out.println("Tiquete con ID de " + idTiquete);
            imprimirTiquete(t);
            return;
        }
        System.out.println("El Tiquete con ID " + idTiquete + " no se encuentra actualmente en el parqueadero."); 
    }
    
    public void mostrarInfoTiquete(String idPersona){
        Tiquete t = buscarTiquete(idPersona);
        if(t != null){
            System.out.println("Tiquete de persona con ID " + idPersona);
            imprimirTiquete(t);
            return;
        }
        System.out.println("La persona con ID " + idPersona + " no tiene tiquetes actualmente en el parqueadero."); 
    }
    
    public void pagarTiquete(Tiquete t){
        if (!verificarTiquete(t)) {
            System.out.println("El Tiquete con ID " + t.getIdTiquete() + " no se encuentra registrado.");
            return;
        }
        t.setEstado("Inactivo");
    }
}
