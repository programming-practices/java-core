package oop.others.zamikanie_vnytrennim_classom;

// Prosto realizem interface

public class Caller {

    private Incremental callbackReference;

    Caller(Incremental cbk) {
        callbackReference = cbk;
    }

    void go() {
        callbackReference.incrementIncremental();
    }
}
