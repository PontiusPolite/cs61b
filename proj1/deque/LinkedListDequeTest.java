package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    public void addFirstTest() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        assertTrue(a.get(2) == 1);
        a.printDeque();
    }

    @Test
    public void addLastTest() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        assertTrue(a.get(2) == 3);
        a.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    @Test
    public void getRecursiveTest() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addFirst(2);
        a.addLast(3);
        a.addFirst(1);
        a.addLast(4);
        a.addLast(5);
        assertTrue("Should have the same value", a.getRecursive(0) == 1);
        assertTrue("Should have the same value", a.getRecursive(1) == 2);
        assertTrue("Should have the same value", a.getRecursive(a.size() - 1) == 5);
    }

    @Test
    public void thoroughDequeTest() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();

        assertTrue(a.isEmpty());
        assertNull(a.get(0));
        assertNull(a.get(-1));
        assertNull(a.get(1));

        // Create list of 10000 elements, 0 through 9999
        for (int i = 0; i < 10000; i += 1) {
            a.addLast(i);
        }
        assertEquals(0, (int) a.get(0));
        assertEquals(0, (int) a.getRecursive(0));
        assertEquals(9999, (int) a.get(9999));
        assertEquals(10, (int) a.getRecursive(10));
        assertFalse(a.isEmpty());
        assertEquals(10000, a.size());
        assertNull(a.get(-1));
        assertNull(a.get(10000));

        assertEquals(0, (int) a.removeFirst());
        assertEquals(1, (int) a.get(0));
        assertEquals(1, (int) a.getRecursive(0));
        assertEquals(11, (int) a.getRecursive(10));
        assertEquals(9999, a.size());
        assertNull(a.get(-1));
        assertNull(a.get(9999));

        assertEquals(9999, (int) a.removeLast());
        assertEquals(5000, (int) a.get(4999));
        assertEquals(9998, (int) a.get(9997));
        assertEquals(11, (int) a.getRecursive(10));
        assertEquals(9998, a.size());
        assertNull(a.get(-1));
        assertNull(a.get(9998));

        for (int i = 0; i < 1000; i += 1) {
            a.removeFirst();
        }
        assertEquals(8998, a.size());

        System.out.println(a.size());

        while(a.size() != 0) {
            a.removeLast();
        }

        a.printDeque();

        assertTrue(a.isEmpty());
        assertNull(a.removeFirst());
        assertNull(a.removeLast());

    }
}
