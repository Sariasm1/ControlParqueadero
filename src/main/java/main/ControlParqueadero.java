/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import modelo.*;
import vista.*;
import controlador.*;

/**
 *
 * @author santi
 */
public class ControlParqueadero {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Parqueadero pUDC = new Parqueadero("UDC", 5000);
        Controlador controlador = new Controlador(pUDC, vista);
        ////
        controlador.cargarSistema();
    }
}
