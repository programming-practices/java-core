package Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new;

public class Main {
    public static void main(String[] args) {
        Parcel3 parce13 = new Parcel3();
        // Must use instance of outer
        // to create an instance of the innre class:
        Parcel3.Conect c = parce13.new Conect();
        Parcel3.Destinaton d = parce13.new Destinaton("Tanzania");
    }
}
