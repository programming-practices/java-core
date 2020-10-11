package generics.anonimnue_vnytrennie_klassu;

import generics.obobwchenui_metod_dlya_ispolzovania_s_heneratorami.Generators;

import java.util.*;


public class BankTeller {

    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }


    public static void main(String[] args) {

        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line) serve(tellers.get(rand.nextInt(tellers.size())), c);
    }
}


