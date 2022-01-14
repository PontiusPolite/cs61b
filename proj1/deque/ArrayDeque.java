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
            addFrontSpaceToArray(size + 1);
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
        Item removed_item = this.get(0);
        items[startIndex] = null;
        startIndex += 1;
        size -= 1;
        if (arrayBelowUsageFactor(0.25)) {
            trimArrayToLength(this.size);
        }
        return removed_item;
    }

    /** Returns true if the ratio of the deque size to the array length is below the
     * specified usage_factor. */
    public boolean arrayBelowUsageFactor(double usage_factor) {
        if (this.size / items.length < usage_factor) {
            return true;
        }
        return false;
    }

    /** Resizes the underlying array to the specified length if that length is larger
     * than the deque size. */
    public void trimArrayToLength(int length) {
        if (length > this.size) {
            return;
        }
        Item[] new_array = (Item[]) new Object[length];
        System.arraycopy(this.items, startIndex, new_array, 0, this.size);
        this.startIndex = 0;
        items = new_array;
    }

    /**
     * Removes and returns the item at the back of the deque.
     */
    @Override
    public Item removeLast() {
        Item removed_item = this.get(this.size - 1);
        items[this.size - 1] = null;
        size -= 1;
        if (arrayBelowUsageFactor(0.25)) {
            trimArrayToLength(this.size);
        }
        return removed_item;
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

    /** Used for testing purposes, prints out the Deque, its size, and indices. */
    private void printStats() {
        System.out.print("Current List: ");
        this.printDeque();
        System.out.println("Size: " + size + "; Start Index: " + startIndex + "; array.length: " + items.length);
    }
}
