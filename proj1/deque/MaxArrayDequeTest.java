package deque;

import net.sf.saxon.functions.Minimax;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Comparator;

/**
 * Created by Carson Crow on 1/14/2022
 */
public class MaxArrayDequeTest {

    @Test
    public void maxTest() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(new intComparator());
        for (int i = 0; i < 10000; i += 1) {
            mad.addLast(i);
        }

        assertEquals((int) mad.max(), 9999);
        mad.removeFirst();
        assertEquals((int) mad.max(), 9999);
        mad.removeLast();
        assertEquals((int) mad.max(), 9998);
    }

    @Test
    public void maxTest2() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(new reverseIntComparator());
        for (int i = 0; i < 10000; i += 1) {
            mad.addLast((int) (Math.random() * 1000));
            if (i == 5000) {
                mad.addLast(5000);
                mad.addLast(-1);
            }
        }

        assertEquals((int) mad.max(new reverseIntComparator()), -1);

    }

    private static class intComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return Integer.compare(x, y);
        }
    }

    /** An opposite comparison to the normal Integer compare, i.e. returns 1 if x < y. */
    private static class reverseIntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return Integer.compare(y, x);
        }
    }



}
