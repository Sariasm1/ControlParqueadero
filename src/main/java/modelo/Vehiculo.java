/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author santi
 */

public abstract class Vehiculo {

    private String tipo;   
    private String marca;
    private String color;

    public Vehiculo(String tipo, String marca, String color) {
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
    }
    
    public Vehiculo(){}

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String m) {
        this.marca = m;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double calcularTarifa();
      
    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Placa: " + ", Marca: " + marca + ", Color: " + color;
    }
}
