/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santi
 */
public class Estudiante extends Usuario {
    private int semestre;
    private String carrera;
    private String nivelAcademico;

    public Estudiante(int semestre, String carrera, String nivelAcademico, String nombre, String celular, String correo, String id) {
        super(nombre, celular, correo, id);
        this.semestre = semestre;
        this.carrera = carrera;
        this.nivelAcademico = nivelAcademico;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    @Override
    public double obtenerDescuento() {
        return 0.1;
    }  

    @Override
    public String toString() {
        return "Estudiante{" + "semestre=" + semestre + ", carrera=" + carrera + ", nivelAcademico=" + nivelAcademico + '}';
    }
}
