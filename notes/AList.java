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

public class AList<Item> {
    private Item[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts x at the end of the list. */
    public void addLast(Item x) {
        // Increases the size of our items array if necessary
        if (size == items.length) {
            resize(size * 2);
        }

        items[size] = x;
        size = size + 1;
    }

    /** Returns the last item in the list. */
    public Item getLast() {
        return items[size - 1];
    }

    /** Returns the i'th item in the list */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the size of the list */
    public int size() {
        return size;
    }

    /** Remove the last element in the list and return it */
    public Item removeLast() {
        // Due to our invariants, by just decreasing the size we 'delete' the last element
        Item x = getLast();
        items[size - 1] = null;
        size = size - 1;
        return x;
    }


}
