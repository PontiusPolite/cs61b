package deque;

public interface Deque<T> {

    /** Adds an item to the front of the deque. */
    public void addFirst(T item);

    /** Adds an item to the back of the deque. */
    public void addLast(T item);

    /** Returns true if deque is empty. */
    public boolean isEmpty();

    /** Returns the number of items in the deque. */
    public int size();

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque();

    /** Removes and returns the item at the front of the deque. */
    public T removeFirst();

    /** Removes and returns the item at the back of the deque. */
    public T removeLast();

    /** Gets the item at the given index, where 0 is the front. If no such item exists,
     *  return null
     */
    public T get(int index);
}
