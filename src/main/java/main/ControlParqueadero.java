/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import modelo.*;

/**
 *
 * @author santi
 */
public class ControlParqueadero {

    public static void main(String[] args) {
        Usuario estudiante = new Estudiante(5, "Ingenieria de sistemas", "Pregrado", "Santiago", "3017425651", "@", "123");
        Tiquete t1 = new Tiquete(1, estudiante);
        Parqueadero pUDC = new Parqueadero("UDC", 5000);
        ////
        pUDC.registrarEntrada(t1);
        pUDC.mostrarTiquetes();
        //
        pUDC.registrarSalida(t1);
        pUDC.mostrarTiquetes();
        pUDC.pagarTiquete(t1);
        pUDC.mostrarInfoTiquete("123");
    }
}
