/**
 * Created by Carson Crow on 12/23/2021
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class ArraySet<T> implements Iterable{
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains (T x) {
        for (int i = 0; i < size; i += 1) {
            if (x.equals(items[i])) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("You can't add null to an ArraySet");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    public int size() {
        return size;
    }

    /** Returns an iterator into ME */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int pos;
        public ArraySetIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            T returnItem = items[pos];
            pos += 1;
            return returnItem;
        }
    }

    public static void main(String[] args) {
        ArraySet<String> aset = new ArraySet<>();
        //s.add(null);
        aset.add("horse");
        aset.add("fish");
        aset.add("house");
        aset.add("fish");
        System.out.println(aset.contains("horse"));
        System.out.println(aset.size());
        System.out.println("-------------------------");

        Set<Integer> javaset = new HashSet<>();
        javaset.add(5);
        javaset.add(23);
        javaset.add(42);

        // Iterator example
        Iterator<Integer> seer = javaset.iterator();
        while (seer.hasNext()) {
            int i = seer.next();
            System.out.println(i);
        }

        for (String a : aset) {
            System.out.println(a);
        }

    }

}
