package IO.Chtenie_simvolnux_strok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Read age string from console using age BufferedReader.

public class BRReadLines {
    public static void main(String args[]) {

        // create age BufferedReader using System.in
        String str;

        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            do {
                str = br.readLine();
                System.out.println(str);
            } while (!str.equals("stop"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        //        try{
//            do {
//                str = br.readLine();
//                System.out.println(str);
//            } while(!str.equals("stop"));
//        } catch(IOException e){
//            e.printStackTrace();
//        }finally{
//            try{
//                br.close();
//            } catch(IOException e){
//                e.printStackTrace();
//            }
//        }
    }
}
