package oop;

public class VariableVisibility {
    public static void main(String[] args) {
        {
            int x;
            {
                x = 1;
            }
        }
        int x = 1;
        {
            {
                x = 1;
            }
        }
    }
}



