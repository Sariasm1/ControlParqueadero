/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import vista.*;
import modelo.*;
import java.time.Duration;
import java.time.LocalDateTime;


/**
 *
 * @author santi
 */
public class Controlador {
    private final Parqueadero parqueadero;
    private final Vista vista;
    
     public Controlador(Parqueadero parqueadero, Vista vista){
        this.parqueadero = parqueadero;
        this.vista = vista;
    }
    
     public void cargarSistema(){
        
    }
    
    public boolean verificarEspacioOcupado(String espacio){
        return parqueadero.getEspaciosOcupados().contains(espacio);
    }
    
    public boolean verificarTiquete(Tiquete t){
        return parqueadero.getListaTiquetes().contains(t);
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
        for (Tiquete t: parqueadero.getListaTiquetes()){
            id++;
            System.out.println("Tiquete #"+id);
            
            vista.imprimirTiquete(horasTiquete(t), parqueadero.getTarifaPorHora(), t);
        }
    }
    
      public void registrarEntrada(Tiquete t){
        if (parqueadero.getEspaciosDisponibles().isEmpty()) {
            System.out.println("Parqueadero lleno, no hay espacios disponibles.");
            return;
        }
        
        if (verificarTiquete(t)) {
            System.out.println("El Tiquete con ID " + t.getIdTiquete() + " ya se encuentra registrado.");
            return;
        }

        t.setFechaHoraEntrada(LocalDateTime.now());
        //
        String espacio = parqueadero.removeEspacioDisponible(0);
        parqueadero.addListaTiquetes(t);
        parqueadero.addEspaciosOcupados(espacio);
        t.setEspacioOcupado(espacio);
        
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
            parqueadero.removeEspaciosOcupados(espacio);
            parqueadero.addEspaciosDisponibles(espacio);
        }
        t.setEspacioOcupado("N/A");
        System.out.println("Se ha registrado la salida del tiquete con ID "+t.getIdTiquete());
      }
      
      public void mostrarInfoTiquete(int idTiquete){
        Tiquete t = buscarTiquete(idTiquete);
        if(t != null){
            System.out.println("Tiquete con ID de " + idTiquete);
            vista.imprimirTiquete(horasTiquete(t), parqueadero.getTarifaPorHora(), t);
            return;
        }
        System.out.println("El Tiquete con ID " + idTiquete + " no se encuentra actualmente en el parqueadero."); 
    }
    
    public void mostrarInfoTiquete(String idPersona){
        Tiquete t = buscarTiquete(idPersona);
        if(t != null){
            System.out.println("Tiquete de persona con ID " + idPersona);
            vista.imprimirTiquete(horasTiquete(t), parqueadero.getTarifaPorHora(), t);
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
      
      public void removerTiquete(Tiquete t){
      if(buscarTiquete(t) != null){
         parqueadero.removeListaTiquetes(t);
         System.out.println("Tiquete con ID "+ t.getIdTiquete()+ " removido con exito.");
         return;
      }
      System.out.println("No se encontró ningún Tiquete con ID "+ t.getIdTiquete() + " en el parqueadero.");
    }
    
    public void removerTiquete(int idTiquete){
      Tiquete t = buscarTiquete(idTiquete);
      if(t != null){
         parqueadero.removeListaTiquetes(t);
         System.out.println("Tiquete con ID "+ t.getIdTiquete()+ " removido con exito.");
         return;
      }
      System.out.println("No se encontró ningún Tiquete con ID "+ idTiquete + " en el parqueadero.");
    }
    
    public Tiquete buscarTiquete(int idTiquete){
        for (Tiquete t : parqueadero.getListaTiquetes()) {
         if (t.getIdTiquete() == idTiquete)  { 
             return t;
            }
         }
     return null;
    }
    
    public Tiquete buscarTiquete(String idPersona){
     for (Tiquete t : parqueadero.getListaTiquetes()) {
         if (t.getUsuario().getId().matches(idPersona)) { 
             return t;
            }
         }
     return null;
    }
    
    public Tiquete buscarTiquete(Tiquete t) {
    if (t != null && parqueadero.getListaTiquetes().contains(t)) {
        return t; 
    }
    return null;
    }
      
}
