/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santi
 */
public class Profesor extends Usuario {
    private String materia;
    private String carrera;

    public Profesor(String materia, String carrera, String nombre, String celular, String correo, String id) {
        super(nombre, celular, correo, id);
        this.materia = materia;
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public double obtenerDescuento() {
       return 0.2;
    }

    @Override
    public String toString() {
        return "Profesor{" + "materia=" + materia + ", carrera=" + carrera + '}';
    }
    
    
    
}
