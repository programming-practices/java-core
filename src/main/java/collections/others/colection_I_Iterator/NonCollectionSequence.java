package collections.others.colection_I_Iterator;

import others.entities.Pet;
import others.entities.Pets;

import java.util.*;

//class PetSequence {
//    protected Pet[] pets = Pets.createArray(8);
//}

public class NonCollectionSequence implements Iterable {

    Pet[] pets = Pets.createArray(8);

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
        System.out.println(" ");

        for (Pet pReversed : nc.reversed()) {
            System.out.print(pReversed + ", ");
        }
        System.out.println(" ");

        for (Pet pRandomized : nc.randomized()) {
            System.out.print(pRandomized + ". ");
        }
        System.out.println(" ");
    }

    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            public boolean hasNext() {
                return index < pets.length;
            }

            public Pet next() {
                return pets[index++];
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int current = pets.length - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public Pet next() {
                        return pets[current--];
                    }

                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {
            public Iterator<Pet> iterator() {
                List<Pet> shuffled =
                        new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }
}
