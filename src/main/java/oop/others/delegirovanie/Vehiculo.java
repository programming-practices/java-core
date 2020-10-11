package Examples.OOP.Others.delegirovanie;

public class Vehiculo {
    private String name;
    private int velosidad;
    private ControlVehiculo control = new ControlVehiculo();

    Vehiculo(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    void irAdelante(int velosidad) {
        control.irAdelante(velosidad);
    }

    void irParaAtras(int velosidad) {
        control.irParaAtras(velosidad);
    }

    void girarAlaDerecha(int velosidad) {
        control.girarAlaDerecha(velosidad);
    }

    void girarAlaIzquierda(int velosidad) {
        control.girarAlaIzquierda(velosidad);
    }
}
