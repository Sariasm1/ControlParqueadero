package modelo;
public class Motocicleta extends VehiculoMotorizado {

    private int cilindraje;

    public Motocicleta(int cilindraje, String placa, String marca, String color) {
        super("Moto", placa, marca, color);
        this.cilindraje = cilindraje;
    }
    
    public Motocicleta(){
        super();
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int c) {
        this.cilindraje = c;
    }

    @Override
    public double calcularTarifa() {
        return 2000 + (cilindraje * 5); 
    }
}