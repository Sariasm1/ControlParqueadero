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
    private static final int espaciosTotales = 5; 
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

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
 
    public boolean verificarEspacioOcupado(String espacio){
        return espaciosOcupados.contains(espacio);
    }
    
    public double horasTiquete(Tiquete t) {
    if (t.getFechaHoraSalida() == null) {
        return 0.0;
    }
    long minutos = Duration.between(t.getFechaHoraEntrada(), t.getFechaHoraSalida()).toMinutes();
    return minutos / 60.0;
}
    
    public void mostrarTiquetes(){
        int id=0;
        for (Tiquete t: listaTiquetes){
            id++;
            System.out.println("Tiquete #"+id);
            System.out.println("Usuario: "+t.getUsuario().getNombre());
            System.out.println("ID: "+t.getIdTiquete());
            //System.out.println("Vehiculo: "+t.getVehiculo().getPlaca());
            System.out.println("Estado: "+t.getEstado());
            System.out.println("Espacio ocupado: "+(t.getEspacioOcupado() != null ? t.getEspacioOcupado() : "N/A"));
            System.out.println("Hora de ingreso: "+ t.getFechaHoraEntrada().format(formato));
            System.out.println("Hora de salida: " + (t.getFechaHoraSalida() != null ? t.getFechaHoraSalida().format(formato) : "N/A"));
            System.out.println("-----------");
            System.out.println("Total: "+ horasTiquete(t) * tarifaPorHora + " COP");
        }
    }
    
    public void registrarTiquete(Tiquete t){
        t.setFechaHoraEntrada(LocalDateTime.now());
        listaTiquetes.add(t);
        System.out.println("Se ha registrado el tiquete con ID "+t.getIdTiquete());
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
