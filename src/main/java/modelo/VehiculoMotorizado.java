/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santi
 */
public abstract class VehiculoMotorizado extends Vehiculo {
    private String placa;

    public VehiculoMotorizado(String tipo, String placa, String marca, String color) {
        super(tipo, marca, color);
        this.placa = placa;
    }
    
    public VehiculoMotorizado(){}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }  
}
