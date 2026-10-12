/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDateTime;

/**
 *
 * @author santi
 */
public class Tiquete {
    private int idTiquete;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private String espacioOcupado;
    private boolean activo;
    private Usuario usuario;
   // private Vehiculo vehiculo;
    private String estado;

    public Tiquete(int idTiquete, Usuario usuario) { //Vehiculo vehiculo
        this.idTiquete = idTiquete;
        this.usuario = usuario;
       // this.vehiculo = vehiculo;
        this.activo = true;
        this.estado = "Pendiente";
    }

    public int getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(int idTiquete) {
        this.idTiquete = idTiquete;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getEspacioOcupado() {
        return espacioOcupado;
    }

    public void setEspacioOcupado(String espacioOcupado) {
        this.espacioOcupado = espacioOcupado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    **/

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "idTiquete=" + idTiquete + ", fechaHoraEntrada=" + fechaHoraEntrada + ", fechaHoraSalida=" + fechaHoraSalida + ", espacioOcupado=" + espacioOcupado + ", activo=" + activo + ", usuario=" + usuario + ", estado=" + estado + '}';
    }
    
    
    
    
    
    
}
