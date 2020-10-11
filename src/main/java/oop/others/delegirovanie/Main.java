package Examples.OOP.Others.delegirovanie;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("Nissan");
        Vehiculo1 vehiculo1 = new Vehiculo1("Ford");
        vehiculo.girarAlaDerecha(23);
        vehiculo1.girarAlaDerecha(23);
    }

}
