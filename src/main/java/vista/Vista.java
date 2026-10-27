/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import modelo.*;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author santi
 */
public class Vista {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    public Vista(){
    }
    
    public void imprimirTiquete(double horasTiquete, double tarifaPorHora, Tiquete t){
        double costoBase = (2 * tarifaPorHora) + t.getVehiculo().calcularTarifa();
        double descuento = costoBase * t.getUsuario().obtenerDescuento();
        //
        System.out.println("Usuario: "+t.getUsuario().getNombre());
        System.out.println("ID: "+t.getIdTiquete());
        System.out.println("Vehiculo: " + t.getVehiculo().getTipo() + " (" + t.getVehiculo().getPlaca() + ")");
        System.out.println("Estado: "+ t.getEstado());
        System.out.println("Espacio ocupado: "+(t.getEspacioOcupado() != null ? t.getEspacioOcupado() : "N/A"));
        System.out.println("Hora de ingreso: "+ t.getFechaHoraEntrada().format(formato));
        System.out.println("Hora de salida: " + (t.getFechaHoraSalida() != null ? t.getFechaHoraSalida().format(formato) : "N/A"));
        System.out.println("Total horas: " + horasTiquete);
        System.out.println("-----------");
        System.out.println("Tarifa base: " + t.getVehiculo().calcularTarifa());
        System.out.println("Valor total: "+ costoBase + " COP");
        System.out.println("Descuento: " + descuento + " (" + t.getUsuario().obtenerDescuento() * 100 + "%)");
        System.out.println("-----------");
        System.out.println("Total a pagar: " + (costoBase - descuento));
        System.out.println("==========================");
}
    
    public void mostrarMensaje(String m) {
        System.out.println(m);
    }
    
}
