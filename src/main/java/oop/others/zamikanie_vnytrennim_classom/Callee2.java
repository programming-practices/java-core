package oop.others.zamikanie_vnytrennim_classom;

//Esli vaw class dolzen vizivat metod incrementIncrementable()
//po-dryhomy, neobxodimo ispolzovat vnytrennii class:

public class Callee2 extends MyIncrement {

    private int i = 0;

    public void incrementMyIncrement() {
        super.incrementMyIncrement();
        i++;
        System.out.println(i);
    }

    Incremental getCallbackReference() {
        return new Closure();
    }

    private class Closure implements Incremental {

        @Override
        public void incrementIncremental() {
            //Ykazuvaem metod vnewnoho class, inache
            // voznikaet bezkonechnaya recursia:
//            incrementIncrementable();
            incrementMyIncrement();
        }
    }
}
