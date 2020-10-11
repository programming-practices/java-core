package others.entities;

import java.util.ArrayList;

public class Pets {

    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> getArrayListPets(int size) {
        return creator.getArrayListPets(size);
    }
}
