package deque;

import org.junit.Test;

import javax.annotation.concurrent.ThreadSafe;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertTrue(a.isEmpty());
        a.addFirst(1);
        assertFalse(a.isEmpty());
//        x.removeFirst();
//        assertTrue(x.isEmpty());
    }

    @Test
    public void testSize() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertEquals(0, a.size());
        for (int i = 0; i < 10000; i += 1) {
            a.addLast(i);
        }
        assertEquals(10000, a.size());
//        for (int i = 0; i < 10000; i += 1) {
//            x.removeLast(i);
//        }
//        assertEquals(0, x.size());
    }

    @Test
    public void testAddItems() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addLast(2);
        assertEquals(2, (int) a.get(0));
        a.addFirst(1);
        assertEquals(1, (int) a.get(0));
        a.addLast(3);
        assertEquals(3, (int) a.get(2));
        a.addFirst(0);
        assertEquals(0, (int) a.get(0));
        assertEquals(1, (int) a.get(1));
        a.addFirst(-1);
        assertEquals(-1, (int) a.get(0));
        assertEquals(5, a.size());
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        for (int i = 0; i < 10000; i += 1) {
            a.addLast(i);
        }

        assertEquals(0, (int) a.get(0));
        assertEquals(9999, (int) a.get(a.size() - 1));
        assertEquals(5000, (int) a.get(5000));

        for (int i = 29999; i >= 20000; i -= 1) {
            a.addFirst(i);
        }

        assertEquals(20000, (int) a.get(0));
        assertEquals(9999, (int) a.get(a.size() - 1));
        assertEquals(29999, (int) a.get(9999));
        assertEquals(25000, (int) a.get(5000));

    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        for (int i = 0; i < 10000; i += 1) {
            a.addLast(i);
        }
        int x = a.removeFirst();
        assertEquals(x, 0);
        x = a.removeFirst();
        assertEquals(x, 1);

        assertEquals(a.size(), 9998);

        while (a.get(0) != 5000) {
            a.removeFirst();
        }
        int y = a.removeFirst();
        assertEquals(y, 5000);
    }

    @Test
    public void testRemoveLast() {
        
    }

}
