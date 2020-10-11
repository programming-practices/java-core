package collections.list.linked_list;

import others.entities.Hamster;
import others.entities.Pet;
import others.entities.Pets;
import others.entities.Rat;

import java.util.LinkedList;

public class LinkedListFeatures {
    public static void main(String[] args) {

        System.out.println("1 -------------------------------------------");
        LinkedList<Pet> petLinkedList = new LinkedList<>(Pets.getArrayListPets(5));
        System.out.println(petLinkedList);

        System.out.println("2 -------------------------------------------");
        // Identical:
        System.out.println("petLinkedList.getFirst(): " + petLinkedList.getFirst());
        System.out.println("petLinkedList.element(): " + petLinkedList.element());

        System.out.println("3 -------------------------------------------");
        // Only differs in empty-list behavior:
        System.out.println("petLinkedList.peek(): " + petLinkedList.peek());

        System.out.println("4 -------------------------------------------");
        // Identical; remove and return the first element:
        System.out.println("petLinkedList.remove(): " + petLinkedList.remove());
        System.out.println("petLinkedList.removeFirst(): " + petLinkedList.removeFirst());

        System.out.println("5 -------------------------------------------");
        // Only differs in empty-list behavior:
        System.out.println(petLinkedList);
        System.out.println("petLinkedList.poll(): " + petLinkedList.poll());
        System.out.println(petLinkedList);

        System.out.println("6 -------------------------------------------");
        petLinkedList.addFirst(new Rat());
        System.out.println("After addFirst(): " + petLinkedList);

        System.out.println("7 -------------------------------------------");
        petLinkedList.offer(Pets.randomPet());
        System.out.println("After offer(): " + petLinkedList);

        System.out.println("8 -------------------------------------------");
        petLinkedList.add(Pets.randomPet());
        System.out.println("After add(): " + petLinkedList);

        System.out.println("9 -------------------------------------------");
        petLinkedList.addLast(new Hamster());
        System.out.println("After addLast(): " + petLinkedList);
        System.out.println("petLinkedList.removeLast(): " + petLinkedList.removeLast());
    }
}
