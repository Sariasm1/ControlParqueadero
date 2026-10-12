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

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
 
    public boolean verificarEspacioOcupado(String espacio){
        return espaciosOcupados.contains(espacio);
    }
    
    public boolean verificarTiquete(Tiquete t){
        return listaTiquetes.contains(t);
    }
    
    
    public double horasTiquete(Tiquete t) {
    if (t.getFechaHoraSalida() == null) {
        return 0.0;
    }
    long minutos = Duration.between(t.getFechaHoraEntrada(), t.getFechaHoraSalida()).toMinutes();
    return minutos / 60.0;
}
    
    public void imprimirTiquete(Tiquete t){
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
    
    public void mostrarTiquetes(){
        int id=0;
        for (Tiquete t: listaTiquetes){
            id++;
            System.out.println("Tiquete #"+id);
            imprimirTiquete(t);
        }
    }
    
    public void registrarEntrada(Tiquete t){
        if (espaciosDisponibles.isEmpty()) {
            System.out.println("Parqueadero lleno, no hay espacios disponibles.");
            return;
        }
        
        if (verificarTiquete(t)) {
            System.out.println("El Tiquete con ID " + t.getIdTiquete() + " ya se encuentra registrado.");
            return;
        }

        t.setFechaHoraEntrada(LocalDateTime.now());
        //
        String espacio = espaciosDisponibles.remove(0);
        listaTiquetes.add(t);
        espaciosOcupados.add(espacio);
        t.setEspacioOcupado(espacio);
        //
        System.out.println("Se ha registrado la entrada del tiquete con ID "+t.getIdTiquete());
    }
    
    public void registrarSalida(Tiquete t){
        if (!verificarTiquete(t)) {
            System.out.println("El Tiquete con ID " + t.getIdTiquete() + " no se encuentra registrado.");
            return;
        }
        
        t.setFechaHoraSalida(LocalDateTime.now());
        t.setEstado("Pendiente de pago");
        t.setActivo(false);
        
        String espacio = t.getEspacioOcupado();
        if (espacio != null) {
            espaciosOcupados.remove(espacio);
            espaciosDisponibles.add(espacio);
        }
        t.setEspacioOcupado("N/A");
        System.out.println("Se ha registrado la salida del tiquete con ID "+t.getIdTiquete());
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
            imprimirTiquete(t);
        }
        System.out.println("El Tiquete con ID " + idTiquete + " no se encuentra actualmente en el parqueadero."); 
    }
    
    public void mostrarInfoTiquete(String idPersona){
        Tiquete t = buscarTiquete(idPersona);
        if(t != null){
            imprimirTiquete(t);
        }
        System.out.println("La persona con ID " + idPersona + " no tiene tiquetes actualmente en el parqueadero."); 
    }
    
}
