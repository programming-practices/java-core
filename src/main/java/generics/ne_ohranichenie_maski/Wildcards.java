package generics.ne_ohranichenie_maski;

import generics.na_skolko_ymien_kompelator.Holder;

public class Wildcards {
    // Raw argument:
    static void rawArgs(Holder holder, Object arg) {
        holder.set(arg); // Warning:
        //   Unchecked call to set(T) as a
        //   member of the raw type HolderValuesInt
        holder.set(new Wildcards()); // Same warning

        // Can't do this; don't have any 'T':
        // T t = holder.get();

        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    // Similar to rawArgs(), but errors instead of warnings:
    static void unboundedArg(Holder<?> holder, Object arg) {
//         holder.set(arg); // Error:
        //   set(capture of ?) in HolderValuesInt<capture of ?>
        //   cannot be applied to (Object)
//         holder.set(new Wildcards()); // Same error

        // Can't do this; don't have any 'T':
//         T t = holder.get();

        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
//         holder.set(arg); // Error:
        //   set(capture of ? extends T) in
        //   HolderValuesInt<capture of ? extends T>
        //   cannot be applied to (T)
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
//         T t = holder.get();  // Error:
        //   Incompatible types: found Object, required T

        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw); // Warnings:
        //   Unchecked conversion from HolderValuesInt to HolderValuesInt<T>
        //   Unchecked method invocation: exact1(HolderValuesInt<T>)
        //   is applied to (HolderValuesInt)
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded); // Must return Object
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, lng); // Warnings:
        //   Unchecked conversion from HolderValuesInt to HolderValuesInt<Long>
        //   Unchecked method invocation: exact2(HolderValuesInt<T>,T)
        //   is applied to (HolderValuesInt,Long)
        Long r6 = exact2(qualified, lng);
//         Long r7 = exact2(unbounded, lng); // Error:
//           exact2(HolderValuesInt<T>,T); //cannot be applied to
        //   (HolderValuesInt<capture of ?>,Long)
        // Long r8 = exact2(bounded, lng); // Error:
        //   exact2(HolderValuesInt<T>,T) cannot be applied
        //   to (HolderValuesInt<capture of ? extends Long>,Long)

        Long r9 = wildSubtype(raw, lng); // Warnings:
        //   Unchecked conversion from HolderValuesInt
        //   to HolderValuesInt<? extends Long>
        //   Unchecked method invocation:
        //   wildSubtype(HolderValuesInt<? extends T>,T) is
        //   applied to (HolderValuesInt,Long)
        Long r10 = wildSubtype(qualified, lng);
        // OK, but can only return Object:
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        wildSupertype(raw, lng); // Warnings:
        //   Unchecked conversion from HolderValuesInt
        //   to HolderValuesInt<? super Long>
        //   Unchecked method invocation:
        //   wildSupertype(HolderValuesInt<? super T>,T)
        //   is applied to (HolderValuesInt,Long)
        wildSupertype(qualified, lng);
        // wildSupertype(unbounded, lng); // Error:
        //   wildSupertype(HolderValuesInt<? super T>,T) cannot be
        //   applied to (HolderValuesInt<capture of ?>,Long)
        // wildSupertype(bounded, lng); // Error:
        //   wildSupertype(HolderValuesInt<? super T>,T) cannot be
        //  applied to (HolderValuesInt<capture of ? extends Long>,Long)
    }
}
