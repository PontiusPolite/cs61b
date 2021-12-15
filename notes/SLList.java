
// Item_type is the name of our new parameter, which determines the type
// of any Item_type variable
public class SLList<Item>{
    /* The first item, if it exists, is at sentinel.next */
    private StuffNode sentinel;
    // We can cache the size to make retrieving it much faster
    private int size;

    /* We can nest this class inside SLList */
    public class StuffNode {
        public Item item;
        public StuffNode next;

        public StuffNode(Item i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    /** Creates an empty SLList */
    public SLList() {
        sentinel = new StuffNode(null, null);
        size = 0;
    }

    public SLList(Item x) {
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(Item x){
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    /** Returns the first item in the list. */
    public Item getFirst(){
        return sentinel.next.item;
    }

    /** Adds x to the end of the list. */
    public void addLast(Item x) {
        StuffNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
        size += 1;
    }

    public Item getLast() {
        StuffNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
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

}