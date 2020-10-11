package YouTube_Channels.Olimpiadnoe_prohramirovanie_s_nulia_na_Java._50_Simvolu_i_stroki_v_Java_Chast_1;

public class ZnachenieZnakovVCifrax {
    public static void main(String[] args) {

        char[] cifras = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        char[] alfavitUpperCase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        char[] alfavitLoweCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


        System.out.println("Cifras");
        for (Character c : cifras) {
            System.out.print((int) c + ", ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Simbolos entre 57 - 65: ");
        for (int i = 58; i < 65; i++) {
            System.out.print((char) i);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Alfabetico Upper Case: ");
        for (Character c : alfavitUpperCase) {
            System.out.print((int) c + ", ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Simbolos entre 90 - 97: ");
        for (int i = 91; i < 97; i++) {
            System.out.print((char) i);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Alfabetico Lower Case: ");
        for (Character c : alfavitLoweCase) {
            System.out.print((int) c + ", ");
        }


    }
}
