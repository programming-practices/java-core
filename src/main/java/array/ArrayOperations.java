package array;

/**
 * Operation on array
 *
 * @author TRL
 */
public final class ArrayOperations {
    private ArrayOperations() {
    }

    /**
     * Cast int[] to Integer[]
     */
    public static Integer[] castIntArrayToIntegerArray(int[] array) {
        Integer[] integers = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            integers[i] = array[i];
        }
        return integers;
    }

    /**
     * Cast char[] to Character[]
     */
    public static Character[] castCharArrayToCharacterArray(char[] array) {
        Character[] characters = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            characters[i] = array[i];
        }
        return characters;
    }
}
