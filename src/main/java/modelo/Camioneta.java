package modelo;
public class Camioneta extends VehiculoMotorizado {

    private double capacidadCarga;

    public Camioneta(double capacidadCarga, String placa, String marca, String color) {
        super("Camioneta", placa, marca, color);
        this.capacidadCarga = capacidadCarga;
    }
    
    public Camioneta(){
        super();
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double c) {
        this.capacidadCarga = c;
    }

    @Override
    public double calcularTarifa() {
        return 8000 + (capacidadCarga * 100); 
    }
}