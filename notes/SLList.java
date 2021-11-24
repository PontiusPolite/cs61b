public class SLList {
    private IntNode first;

    /* We can nest this class inside SLList */
    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds x to the front of the list */
    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    /** Returns the first item in the list */
    public int getFirst(){
        return first.item;
    }

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(10);
        L.addFirst(5);
    }
}