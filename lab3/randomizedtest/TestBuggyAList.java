package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    /** Tests the two AList implementations by adding and removing three elements. Not robust
     * enough to determine the bug in BuggyAList.
     */
    @Test
    public void testThreeAddRemove() {
        AListNoResizing<Integer> working = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        for (int i = 4; i < 7; i += 1) {
            working.addLast(i);
            buggy.addLast(i);
        }

        for (int i = 0; i < 3; i += 1) {
            assertEquals(working.removeLast(), buggy.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int Bsize = B.size();
                assertEquals(size, Bsize);
                System.out.println("size: " + size);
            } else if(operationNumber == 2 && L.size() != 0) {
                // getLast
                int x = L.getLast();
                int y = B.getLast();
                assertEquals(x, y);
                assertEquals(L.size(), B.size());
                System.out.println("getLast() = " + x);
            } else if(operationNumber == 3 && L.size() != 0) {
                // removeLast
                int x = L.removeLast();
                int y = B.removeLast();
                assertEquals(x, y);
                assertEquals(L.size(), B.size());
                System.out.println("removeLast() = " + x);
            }
        }

    }

}
