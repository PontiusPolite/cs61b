package deque;

public class ArrayDeque<Item> implements Deque<Item>{

    private Item[] items;
    private int size;
    // startIndex refers to the index of our first item in the items array
    // There is a buffer of memory boxes at both the front and back of our array for adding first
    // and last elements.
    private int startIndex;

    /** Create an empty ArrayDeque */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        startIndex = 0;
    }

    /** Adds space in the front of our array for adding elements */
    private void addFrontSpaceToArray(int space) {
        Item[] new_array = (Item[]) new Object[space + size];
        System.arraycopy(items, 0, new_array, space, size);
        startIndex += space;
        items = new_array;
    }

    /** Adds space at the back of our array for adding elements */
    private void addBackSpaceToArray(int space) {
        Item[] new_array = (Item[]) new Object[space + size];
        System.arraycopy(items, 0, new_array, 0, size);
        items = new_array;
    }

    /**
     * Adds an item to the front of the deque.
     *
     * @param item
     */
    @Override
    public void addFirst(Item item) {
        if (!spaceAvailableInFront()) {
            addFrontSpaceToArray(size);
        }

        startIndex -= 1;
        items[startIndex] = item;
        size += 1;
    }

    /** Returns true if there is space available in the array before the first item. */
    private boolean spaceAvailableInFront() {
        if (startIndex == 0) {
            return false;
        }
        return true;
    }

    /**
     * Adds an item to the back of the deque.
     *
     * @param item
     */
    @Override
    public void addLast(Item item) {
        if (!spaceAvailableInBack()) {
            addBackSpaceToArray(size);
        }

        items[size] = item;
        size += 1;
    }

    /** Returns true if there is space available in the array after the last item. */
    private boolean spaceAvailableInBack() {
        if (startIndex + size == items.length) {
            return false;
        }
        return true;
    }

    /**
     * Returns true if deque is empty.
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    @Override
    public void printDeque() {
        for (int i = startIndex; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     */
    @Override
    public Item removeFirst() {
        return null;
    }

    /**
     * Removes and returns the item at the back of the deque.
     */
    @Override
    public Item removeLast() {
        return null;
    }

    /**
     * Gets the item at the given index, where 0 is the front. If no such item exists,
     * return null
     *
     * @param index
     */
    @Override
    public Item get(int index) {
        return items[index + startIndex];
    }

    /** Used for testing, delete after */
    private void printStats() {
        System.out.print("Current List: ");
        this.printDeque();
        System.out.println("Size: " + size + "; Start Index: " + startIndex + "; array.length: " + items.length);
    }
}
