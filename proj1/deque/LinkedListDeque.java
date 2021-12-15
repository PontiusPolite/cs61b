package deque;

public class LinkedListDeque<Item> implements Deque<Item>{

    /** Our LinkedListDeque is comprised of Nodes. Each Node has a next and
     * prev (previous) pointer, as well as a value of type Item.
     */
    public class Node {
        public Item item;
        public Node next;
        public Node prev;

        /** Create an empty Node that points only to itself */
        public Node() {
            item = null;
            next = this;
            prev = this;
        }

        public Node(Item item, Node previous, Node next) {
            this.item = item;
            this.next = next;
            this.prev = previous;
        }
    }

    // Invariants:
    // sentinel.next always points to the first item in the list
    // sentinel.prev always points to the last item in the list
    // For Node n, n.next.prev always points to n
    private Node sentinel;
    private int size;

    /** Create an empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel = new Node();
        size = 0;
    }

    @Override
    public void addFirst(Item item) {
        Node added_node = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = added_node;
        sentinel.next = added_node;
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        Node added_node = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = added_node;
        sentinel.prev = added_node;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (Node n = sentinel.next; n != sentinel; n = n.next){
            System.out.print(n.item + " ");
        }
    }

    @Override
    public Item removeFirst() {
        if (this.isEmpty()){
            return null;
        }

        Item removed_item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return removed_item;
    }

    @Override
    public Item removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        Item removed_item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return removed_item;
    }

    @Override
    public Item get(int index) {
        if (isValidIndex(index)){
            Node p = sentinel.next;
            while(index != 0) {
                p = p.next;
                index -= 1;
            }
            return p.item;
        }
        return null;
    }

    /** Returns the item at the index. */
    public Item getRecursive(int index) {
        if (isValidIndex(index)){
            return getRecursiveHelper(index, sentinel.next);
        }
        return null;
    }

    /** Returns the item at the index starting at node n. */
    private Item getRecursiveHelper(int index, Node n) {
        if (index == 0) {
            return n.item;
        }
        return getRecursiveHelper(index - 1, n.next);
    }

    /** Returns true if the index is valid for the list. */
    private boolean isValidIndex(int index){
        return (index >= 0 && index < size);
    }
}
