package modelo;

public class Automovil extends Vehiculo {

    public Automovil(String placa, String marca, String color) {
        super("Carro", placa, marca, color);
    }

    @Override
    public double calcularTarifa() {
        return 5000; 
    }
}
