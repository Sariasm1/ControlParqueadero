package modelo;

public class Automovil extends VehiculoMotorizado {

    public Automovil(String placa, String marca, String color) {
        super("Carro", placa, marca, color);
    }
    
    public Automovil(){
        super();
    }

    @Override
    public double calcularTarifa() {
        return 5000; 
    }
}
