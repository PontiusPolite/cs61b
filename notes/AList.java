/**
 * Array Based List
 * @author Carson Crow
 */

/*
Invariants:
- The position of the next item to be inserted is always size.
- Size is always the number of items in the Alist.
- The last item in the list is always in position size - 1.
 */

public class AList {
    private int[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts x at the end of the list. */
    public void addLast(int x) {
        // Increases the size of our items array if necessary
        if (size == items.length) {
            resize(size + 1);
        }

        items[size] = x;
        size = size + 1;
    }

    /** Returns the last item in the list. */
    public int getLast() {
        return items[size - 1];
    }

    /** Returns the i'th item in the list */
    public int get(int i) {
        return items[i];
    }

    /** Returns the size of the list */
    public int size() {
        return size;
    }

    /** Remove the last element in the list and return it */
    public int removeLast() {
        // Due to our invariants, by just decreasing the size we 'delete' the last element
        int x = getLast();
        size = size - 1;
        return x;
    }


}
