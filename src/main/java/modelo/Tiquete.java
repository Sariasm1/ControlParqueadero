package modelo;
import utilidades.*;
import java.time.LocalDateTime;

public class Tiquete {
    private int idTiquete;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private Espacio espacioOcupado;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private EstadoTiquete estado;

    public Tiquete(int idTiquete, Usuario usuario, Vehiculo vehiculo) {
        this.idTiquete = idTiquete;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.estado = EstadoTiquete.ACTIVO;
    }
    
    public Tiquete(){}

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void setEspacio(Espacio espacio){
        this.espacioOcupado = espacio;
    }
    
    public Espacio getEspacioOcupado() {
        return espacioOcupado;
    }
    
    public EstadoTiquete getEstado() {
        return estado;
    }

    public void setEstado(EstadoTiquete estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "idTiquete=" + idTiquete + ", fechaHoraEntrada=" + fechaHoraEntrada
                + ", fechaHoraSalida=" + fechaHoraSalida + ", espacioOcupado=" + espacioOcupado
                +  ", usuario=" + usuario + ", vehiculo=" + vehiculo
                + ", estado=" + estado + '}';
    }
}