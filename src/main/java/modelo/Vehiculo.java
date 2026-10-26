package modelo;
public class Vehiculo {

    private String tipo;   // "Carro", "Camioneta", "Bicicleta" o "Moto"
    private String placa;
    private String marca;
    private String color;

    public Vehiculo(String tipo, String placa, String marca, String color) {
        this.tipo = tipo;
        this.placa = placa;
        this.marca = marca;
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPlaca(String p) {
        this.placa = p;
    }

    public void setMarca(String m) {
        this.marca = m;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double calcularTarifa();
       
    

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Placa: " + placa + ", Marca: " + marca + ", Color: " + color;
    }
}
