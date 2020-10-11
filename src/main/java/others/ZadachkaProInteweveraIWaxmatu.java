package others;

public class ZadachkaProInteweveraIWaxmatu {
    public static void main(String[] args) {
        int totalPerson = 2016;
        int partidas = 0;
        int tmp = totalPerson;
        do {
            tmp = tmp / 2;
            System.out.println(tmp);
            partidas += tmp;
        } while (tmp != 1);
        System.out.println("----------------------");
        System.out.println(partidas);

    }


}
