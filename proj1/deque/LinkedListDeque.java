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

        public Node(Item v, Node n, Node p) {
            item = v;
            next = n;
            prev = p;
        }
    }

    // sentinel.next always points to the first item in the list
    // sentinel.prev always points to the last item in the list
    private Node sentinel;
    private int size;

    /** Create an empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel = new Node();
        size = 0;
    }

    @Override
    public void addFirst(Item item) {
        Node added_node = new Node(item, sentinel.next, sentinel);
        if (this.isEmpty()){
            sentinel.prev = added_node;
        }
        sentinel.next = added_node;
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        Node added_node = new Node(item, sentinel, sentinel.prev);
        if (this.isEmpty()) {
            sentinel.next = added_node;
        }
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
        if (!this.isEmpty()){
            Item removed_item = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return removed_item;
        }
        return null;
    }

    @Override
    public Item removeLast() {
        if (!this.isEmpty()) {
            Item removed_item = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return removed_item;
        }
        return null;
    }

    @Override
    public Item get(int index) {
        Node p = sentinel.next;
        while(index != 0) {
            if (p == sentinel) {
                return null;
            }
            p = p.next;
            index -= 1;
        }
        return p.item;
    }
}
