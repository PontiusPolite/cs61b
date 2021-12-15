public interface List61B<Item> {

    /** Inserts x at the end of the list. */
    public void addLast(Item x);

    /** Returns the last item in the list. */
    public Item getLast();

    /** Returns the i'th item in the list */
    public Item get(int i);

    /** Returns the size of the list */
    public int size();

    /** Remove the last element in the list and return it */
    public Item removeLast();

    default public void print() {
        for (int i = 0; i < this.size(); i += 1) {
            System.out.print(this.get(i) + " ");
        }
    }

}
