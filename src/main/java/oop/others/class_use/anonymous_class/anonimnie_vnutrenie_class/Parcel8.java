package Examples.OOP.Others.class_use.anonymous_class.anonimnie_vnutrenie_class;

import Examples.OOP.Others.class_use.inner_class.Wrapping;

// Vizov konstryktora bazovoho classa
public class Parcel8 {
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }

    public Wrapping wrapping(int x) {
        // Vizov constructora bazovoho classa:
        return new Wrapping(x) {// Peredacha arhumenta constryctory
            public int value() {
                return super.value() * 47;
            }
        }; // Tochka s zapiatoy obezatelna
    }
}
