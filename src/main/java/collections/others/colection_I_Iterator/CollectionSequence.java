package collections.others.colection_I_Iterator;

import others.entities.Pet;
import others.entities.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection<Pet> {

    private Pet[] pets = Pets.createArray(8);

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }

    public int size() {
        return pets.length;
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
}
