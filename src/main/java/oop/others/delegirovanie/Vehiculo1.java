package Examples.OOP.Others.delegirovanie;

public class Vehiculo1 extends ControlVehiculo {
    private String name;

    Vehiculo1(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
