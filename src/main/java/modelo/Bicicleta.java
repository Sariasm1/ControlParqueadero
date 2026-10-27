package modelo;
public class Bicicleta extends Vehiculo {

    private boolean esElectrico;

    public Bicicleta(boolean esElectrico, String marca, String color) {
        super("Bicicleta", "N/A", marca, color); // las bicicletas no tienen placa
        this.esElectrico = esElectrico;
    }

    public boolean getEsElectrico() {
        return esElectrico;
    }

    public void setEsElectrico(boolean b) {
        this.esElectrico = b;
    }

    @Override
    public double calcularTarifa() {
    if (esElectrico) {
        return 1500;
    } else {
        return 500;
    }
}
    
}