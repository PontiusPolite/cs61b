public class SLList {
    /* The first item, if it exists, is at sentinel.next */
    private IntNode sentinel;
    private IntNode first;
    // We can cache the size to make retrieving it much faster
    private int size;

    /* We can nest this class inside SLList */
    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /** Creates an empty SLList */
    public SLList() {
        sentinel = new IntNode(42, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(42, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Returns the first item in the list. */
    public int getFirst(){
        return sentinel.next.item;
    }

    /** Adds x to the end of the list. */
    public void addLast(int x) {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
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