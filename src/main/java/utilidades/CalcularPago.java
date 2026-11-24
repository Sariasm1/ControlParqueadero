/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;
import modelo.*;
import java.time.*;

/**
 *
 * @author santi
 */
public class CalcularPago {
    
    public CalcularPago() {}
    
    public double calcularHoras(Tiquete t) {
        if (t.getFechaHoraEntrada() == null || t.getFechaHoraSalida() == null) {
            return 0.0;
        }
        long minutos = Duration.between(t.getFechaHoraEntrada(), t.getFechaHoraSalida()).toMinutes();
        return minutos / 60.0;
    }

    public double calcularCostoBase(Tiquete t, double tarifaPorHora) {
        double horas = calcularHoras(t);
        return (horas * tarifaPorHora) + t.getVehiculo().calcularTarifa();
    }

    public double calcularDescuento(Tiquete t, double tarifaPorHora) {
        double costoBase = calcularCostoBase(t, tarifaPorHora);
        return costoBase * t.getUsuario().obtenerDescuento();
    }

    public double calcularTotalAPagar(Tiquete t, double tarifaPorHora) {
        double costoBase = calcularCostoBase(t, tarifaPorHora);
        double descuento = calcularDescuento(t, tarifaPorHora);
        return costoBase - descuento;
    }
}
