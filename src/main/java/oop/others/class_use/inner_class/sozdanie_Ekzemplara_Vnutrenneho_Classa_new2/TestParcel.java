package Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new2;

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 parce14 = new Parcel4();
        Contents c = parce14.contents();
        Destination d = parce14.destination("Hola");
        // Obwchenie k zakritomy class nevozmozno:
        // ! Parece14.PContents pc = parce14.new PContents();

        // Constructor private:
//        Parce14.PDestination pd = parce14.new PDestination();
    }
}
