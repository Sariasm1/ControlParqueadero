/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import vista.*;
import modelo.*;
import java.time.Duration;
import java.time.LocalDateTime;
import utilidades.*;


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
         
        /*
         Hola, este programa corresponde a un sistema de gestión de parqueaderos en el contexto de la universidad diseñado para administrar tiquetes de servicio, 
         registrar los datos del usuario y del vehículo (como el tipo y la placa), y llevar un control de las horas de ingreso y salida. Asimismo, administra los 
         estados del servicio como "Pendiente de pago" y cuenta con lógica para calcular tarifas, aplicar descuentos porcentuales y determinar el monto total 
         a pagar por el cliente, según su rol en la universidad y el tipo de vehiculoD.
         
         De momento no se incluyen funciones como registrarTiquete, registrarUsuario, registrarVehiculo. Directamente creamos el objeto con su constructor haciendo
         la referencia directa. En un futuro en el que se vaya aplicar interfaces y se agreguen nuevas interacciones al sistema, será necesario implementarlo.A
        */
            
        // Creación objeto usuario
        Usuario estudiante1 = new Estudiante(5, "Ingenieria de sistemas", "Pregrado", "Santiago", "3017425651", "@", "123");
        Usuario estudiante2 = new Estudiante(6, "Ingenieria de alimentos", "Pregrado", "Juan", "306534321", "@", "456");
        // Creacion objeto vehiculo
        Vehiculo camioneta = new Camioneta(30, "BFD-233", "Toyota", "Negro");
        Vehiculo moto = new Motocicleta(150, "LTP-32I", "Yamaha", "Azul");
        // Creacion objeto Tiquete
        Tiquete t1 = registrarEntrada(1, estudiante1, camioneta);
        Tiquete t2 = registrarEntrada(2, estudiante2, moto);
        ///
        System.out.println("-----------");
        mostrarTiquetes(); // Imprimos todos los tiquetes.
        registrarSalida(t1); // Registramos la salida del tiquete: Al hacer esto, el tiquete pasa a "Estado" de "Pendiente de pago" y su "Espacio ocupado" a "N/A".
        System.out.println("-----------");
        mostrarTiquetes(); // Imprimos todos los tiquete para ver los cambios.
        pagarTiquete(t1); // Pagamos el tiquete 1: Al hacer esto, el tiquete pasa a "Estado" de "Inactivo".
        pagarTiquete(t2);
        mostrarInfoTiquete("123"); // Sobrecarga de metodo con String.
        mostrarInfoTiquete(1); // Sobrecarga de metodo con int.
    }
    
     public boolean verificarEspacioOcupado(String codigoEspacio) {
            for (Espacio e : parqueadero.getEspacios()) {
                if (e.getCodigo().equals(codigoEspacio) && e.getEstado() == EstadoEspacio.OCUPADO) {
                    return true;
            }
        }
        return false;
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
            vista.mostrarMensaje("Tiquete #"+id);
            
            vista.imprimirTiquete(parqueadero.getTarifaPorHora(), t);
        }
     } 
      
      public Tiquete registrarEntrada(int id, Usuario u, Vehiculo v) {
        Espacio espacio = parqueadero.obtenerEspacioDisponible();
        if (espacio == null) {
            vista.mostrarMensaje("Parqueadero lleno, no hay espacios disponibles.");
            return null;
        }

         Tiquete t = parqueadero.crearTiquete(id, u, v);
         t.setFechaHoraEntrada(LocalDateTime.now());
         espacio.setEstado(EstadoEspacio.OCUPADO);
         t.setEspacio(espacio); 
         vista.mostrarMensaje("Se ha registrado la entrada del tiquete con ID " + t.getIdTiquete());
        return t;
    }

        public void registrarSalida(Tiquete t) {
            if (t == null || !verificarTiquete(t)) {
                vista.mostrarMensaje("El Tiquete no se encuentra registrado.");
                return;
            }

            t.setFechaHoraSalida(LocalDateTime.now());
            t.setEstado(EstadoTiquete.PENDIENTE);

            Espacio espacio = t.getEspacioOcupado();
            if (espacio != null) {
                espacio.setEstado(EstadoEspacio.DISPONIBLE);
            }
            t.setEspacio(null); 
            vista.mostrarMensaje("Se ha registrado la salida del tiquete con ID " + t.getIdTiquete());
        }

      
      public void mostrarInfoTiquete(int idTiquete){
        Tiquete t = buscarTiquete(idTiquete);
        if(t != null){
            vista.mostrarMensaje("Tiquete con ID de " + idTiquete);
            vista.imprimirTiquete(parqueadero.getTarifaPorHora(), t);
            return;
        }
        vista.mostrarMensaje("El Tiquete con ID " + idTiquete + " no se encuentra actualmente en el parqueadero.");
    }
    
    public void mostrarInfoTiquete(String idPersona){
        Tiquete t = buscarTiquete(idPersona);
        if(t != null){
            vista.mostrarMensaje("Tiquete de persona con ID " + idPersona);
            vista.imprimirTiquete(parqueadero.getTarifaPorHora(), t);
            return;
        }
        vista.mostrarMensaje("La persona con ID " + idPersona + " no tiene tiquetes actualmente en el parqueadero.");
    }
      
     public void pagarTiquete(Tiquete t){
        if (!verificarTiquete(t)) {
            vista.mostrarMensaje("El Tiquete con ID " + t.getIdTiquete() + " no se encuentra registrado.");
            return;
        }
        
        if(t.getEstado() == EstadoTiquete.PAGADO){
            vista.mostrarMensaje("El tiquete con ID " + t.getIdTiquete() + " ya se encuentra pagado.");
            return;
        }
        
        t.setEstado(EstadoTiquete.PAGADO);
        vista.mostrarMensaje("Se ha hecho el pago del Tiquete con ID " + t.getIdTiquete());
    }
      
      public void removerTiquete(Tiquete t){
      if(buscarTiquete(t) != null){
         parqueadero.removeListaTiquetes(t);
         vista.mostrarMensaje("Tiquete con ID "+ t.getIdTiquete()+ " removido con exito.");
         return;
      }
      vista.mostrarMensaje("No se encontró ningún Tiquete con ID "+ t.getIdTiquete() + " en el parqueadero.");
    }
    
    public void removerTiquete(int idTiquete){
      Tiquete t = buscarTiquete(idTiquete);
      if(t != null){
         parqueadero.removeListaTiquetes(t);
         vista.mostrarMensaje("Tiquete con ID "+ t.getIdTiquete()+ " removido con exito.");
         return;
      }
      vista.mostrarMensaje("No se encontró ningún Tiquete con ID "+ idTiquete + " en el parqueadero.");
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
