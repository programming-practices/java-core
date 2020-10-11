package oop.others.zamikanie_vnytrennim_classom;

public class Callee1 implements Incremental {

    private int i = 0;

    @Override
    public void incrementIncremental() {
        i++;
        System.out.println(i);
    }

}
