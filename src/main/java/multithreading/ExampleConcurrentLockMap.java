package multithreading;

/*import org.jetbrains.annotations.NotNull;*/

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ExampleConcurrentLockMap {
    private Map<Integer, String> map = new ConcurrentHashMap<>();


    public synchronized String get(Object key) {
        return map.get(key);
    }

    public synchronized String put(Integer key, String value) {
        return map.put(key, value);
    }

    public <K, V> Map<K, V> syncronizedMap(Map<K, V> m) {
        return new MyMap<>(m);
    }

    private static class MyMap<T0, T1> implements Map<T0, T1> {
        private final Map<T0, T1> m;
        private ReadWriteLock rwLock = new ReentrantReadWriteLock();
        private Lock rLock = rwLock.readLock();
        private Lock wLock = rwLock.writeLock();

        public MyMap(Map<T0, T1> m) {
            this.m = m;
        }

        @Override
        public int size() {
            // Tak mozno blokirovat metodu
            // Pripuskaem chto metod size nado wtob imel blokirovky
            rLock.lock();
            try {
                return m.size();
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public T1 put(T0 key, T1 value) {
            wLock.lock();
            try {
                return m.put(key, value);
            } finally {
                wLock.unlock();
            }
        }

        @Override
        public boolean isEmpty() {
            rLock.lock();
            try {
                return m.isEmpty();
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public T1 get(Object key) {
            return null;
        }

        @Override
        public T1 remove(Object key) {
            return null;
        }

        @Override
        public void putAll(/*@NotNull*/ Map<? extends T0, ? extends T1> m) {

        }

        @Override
        public void clear() {

        }

        /* @NotNull*/
        @Override
        public Set<T0> keySet() {
            return null;
        }

        /*@NotNull*/
        @Override
        public Collection<T1> values() {
            return null;
        }

        /*@NotNull*/
        @Override
        public Set<Entry<T0, T1>> entrySet() {
            return null;
        }
    }
}