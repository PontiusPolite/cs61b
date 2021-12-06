
// Item_type is the name of our new parameter, which determines the type
// of any Item_type variable
public class SLList<Item_type> {
    /* The first item, if it exists, is at sentinel.next */
    private StuffNode sentinel;
    private StuffNode first;
    // We can cache the size to make retrieving it much faster
    private int size;

    /* We can nest this class inside SLList */
    public class StuffNode {
        public Item_type item;
        public StuffNode next;

        public StuffNode(Item_type i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    /** Creates an empty SLList */
    public SLList() {
        sentinel = new StuffNode(42, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new StuffNode(42, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(Item_type x){
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    /** Returns the first item in the list. */
    public int getFirst(){
        return sentinel.next.item;
    }

    /** Adds x to the end of the list. */
    public void addLast(Item_type x) {
        StuffNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
        size += 1;
    }

    public int size() {
        return size;
    }

    /** Returns the size of the list using helper function. */
//    public int size() {
//        return size(first);
//    }

    /** Returns the size of the list starting at IntNode p recursively (slow). */
//    public int size(IntNode p) {
//        if (first.next == null) {
//            return 1;
//        }
//        return 1 + size(first.next);
//    }

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(10);
        L.addFirst(5);
    }
}