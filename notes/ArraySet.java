/**
 * Created by Carson Crow on 12/23/2021
 */

import java.util.HashSet;
import java.util.*;

public class ArraySet<T> implements Iterable<T>{
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

    /*
    @Override
    public String toString() {
        // Warning: this is very slow. Adding a single character requires a new copy of the string
        String returnString = "{";
        for (int i = 0; i < size - 1; i += 1) {
            returnString += items[i].toString();
            returnString += ", ";
        }
        returnString += items[size - 1];
        returnString += "}";

        // We can use a string builder instead, which runs in linear time
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i += 1) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        return returnSB.toString();
    } */

    @Override
    /** A better toString method than the one above, using join(). */
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for (T x : this) {
            listOfItems.add(x.toString());
        }
        return "{" + String.join(",", listOfItems) + "}";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /** Allows you to create an ArraySet by plugging in a list of values */
    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) { // A var-arg, variable number of arguments
        ArraySet<Glerp> returnSet = new ArraySet<>();
        for (Glerp x : stuff) {
            returnSet.add(x);
        }
        return returnSet;
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

        for (String a : aset) {
            System.out.println(a);
        }

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

        System.out.println("-------------------------");

        ArraySet<String> ofExample = ArraySet.of("hi", "how", "are", "you");
        System.out.println(ofExample);




    }

}
