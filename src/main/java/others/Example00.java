package others;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.math.BigInteger;

public class Example00 {
    private static boolean fast = true;
//--------------------------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        long v1 = 11;
        long v2 = 12;

        System.out.println(muliplyNative00(v1, v2));

        System.out.println(muliplyNative01(v1, v2));

    }

//---------------------------------------------------------------------------------------------------------------------------------------

    public static BigInteger muliplyNative00(long value_1, long value_2) {
        return BigInteger.valueOf(value_1).multiply(BigInteger.valueOf(value_2));
    }

//--------------------------------------------------------------------------------------------------------------------------------------

    public static BigInteger muliplyNative01(long value_1, long value_2) {
        return BigInteger.valueOf(value_1 * value_2);
    }

//--------------------------------------------------------------------------------------------------------------------------------------

    public static BigInteger muliplyNative02(long value_1, long value_2) {

        try {
            return BigInteger.valueOf(Math.multiplyExact(value_1, value_2));
        } catch (ArithmeticException e) {
            return BigInteger.valueOf(value_1).multiply(BigInteger.valueOf(value_2));
        }
    }

    static BigInteger multiplySwitch(long a, long b) {
        if (fast) {
            try {
                return BigInteger.valueOf(Math.multiplyExact(a, b));
            } catch (ArithmeticException ex) {
                fast = false;
            }
        }
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
    }

//--------------------------------------------------------------------------------------------------------------------------------------

    static class MultiplyCallSite extends MutableCallSite {
        // Тип: принимает два long'а, возвращает BigInteger
        static final MethodType TYPE = MethodType.methodType(BigInteger.class, long.class, long.class);

        private static final MethodHandle FAST;
        private static final MethodHandle SLOW;

        static {
            try {
                FAST = MethodHandles.lookup().findVirtual(MultiplyCallSite.class, "fast", TYPE);
                SLOW = MethodHandles.lookup().findStatic(MultiplyCallSite.class, "slow", TYPE);
            } catch (NoSuchMethodException | IllegalAccessException e) {
                throw new InternalError(e); // Дурацкие проверяемые исключения!
            }
        }

        MultiplyCallSite(MethodType type) {
            super(type);
            // привязываем нестатический метод FAST к this
            setTarget(FAST.bindTo(this).asType(type));
        }

        static BigInteger slow(long a, long b) {
            return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
        }

        BigInteger fast(long a, long b) {
            try {
                return BigInteger.valueOf(Math.multiplyExact(a, b));
            } catch (ArithmeticException ex) {
                // Меняем реализацию на медленную: SLOW уже статический метод, он больше ничего не меняет
                setTarget(SLOW.asType(type()));
                return slow(a, b);
            }
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------------

    class DynamicMultiplier {
        private boolean fast = true;

        BigInteger multiply(long a, long b) {
            if (fast) {
                try {
                    return BigInteger.valueOf(Math.multiplyExact(a, b));
                } catch (ArithmeticException ex) {
                    fast = false;
                }
            }
            return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------------
}
