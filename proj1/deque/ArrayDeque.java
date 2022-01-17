package deque;

public class ArrayDeque<T> implements Deque<T>{

    private T[] items;
    private int size;
    // startIndex refers to the index of our first item in the items array
    // There is a buffer of memory boxes at both the front and back of our array for adding first
    // and last elements.
    private int start_index;

    /** Create an empty ArrayDeque */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        start_index = 0;
    }

    /** Adds space in the front of our array for adding elements */
    private void addFrontSpaceToArray(int space) {
        T[] new_array = (T[]) new Object[space + size];
        System.arraycopy(items, 0, new_array, space, size);
        start_index += space;
        items = new_array;
    }

    /** Adds space at the back of our array for adding elements */
    private void addBackSpaceToArray(int space) {
        T[] new_array = (T[]) new Object[space + size];
        System.arraycopy(items, 0, new_array, 0, size);
        items = new_array;
    }

    /**
     * Adds an item to the front of the deque.
     *
     * @param t
     */
    @Override
    public void addFirst(T t) {
        if (!spaceAvailableInFront()) {
            addFrontSpaceToArray(size + 1);
        }

        start_index -= 1;
        items[start_index] = t;
        size += 1;
    }

    /** Returns true if there is space available in the array before the first item. */
    private boolean spaceAvailableInFront() {
        if (start_index != 0) {
            return true;
        }
        return false;
    }

    /**
     * Adds an item to the back of the deque.
     *
     * @param t
     */
    @Override
    public void addLast(T t) {
        if (!spaceAvailableInBack()) {
            addBackSpaceToArray(size);
        }

        items[size + start_index] = t;
        size += 1;
    }

    /** Returns true if there is space available in the array after the last item. */
    private boolean spaceAvailableInBack() {
        if (start_index + size != items.length) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if deque is empty.
     */
//    @Override
//    public boolean isEmpty() {
//        return (size == 0);
//    }

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
        for (int i = start_index; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     */
    @Override
    public T removeFirst() {
        T removed_t = this.get(0);
        items[start_index] = null;
        start_index += 1;
        size -= 1;
        if (isArrayBelowUsageFactor(0.25)) {
            trimArrayToLength(this.size);
        }
        return removed_t;
    }

    /** Returns true if the ratio of the deque size to the array length is below the
     * specified usage_factor. */
    public boolean isArrayBelowUsageFactor(double usage_factor) {
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
        T[] new_array = (T[]) new Object[length];
        System.arraycopy(this.items, start_index, new_array, 0, this.size);
        start_index = 0;
        items = new_array;
    }

    /**
     * Removes and returns the item at the back of the deque.
     */
    @Override
    public T removeLast() {
        T removed_t = this.get(this.size - 1);
        items[this.size - 1] = null;
        size -= 1;
        if (isArrayBelowUsageFactor(0.25)) {
            trimArrayToLength(this.size);
        }
        return removed_t;
    }

    /**
     * Gets the item at the given index, where 0 is the front. If no such item exists,
     * return null
     *
     * @param index
     */
    @Override
    public T get(int index) {
        return items[index + start_index];
    }

    /** Used for testing purposes, prints out the Deque, its size, and indices. */
    private void printStats() {
        System.out.print("Current List: ");
        this.printDeque();
        System.out.println("Size: " + size + "; Start Index: " + start_index + "; array.length: " + items.length);
    }
}
