package byow.tests;

import byow.Core.Rectangle;
import byow.Core.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Carson Crow on 9/18/2022
 */
public class RectangleTest {

    @Test
    public void testContains() {
        Rectangle r = new Rectangle(0, 0, 10, 10);
        Position p = new Position(11, 11);
        assertFalse(r.contains(p));
        p = new Position(10, 10);
        assertTrue(r.contains(p));
        p = new Position(-1, 0);
        assertFalse(r.contains(p));
        p = new Position(5, 5);
        assertTrue(r.contains(p));
    }

    @Test
    public void testIntersectsWith() {
        Rectangle r1 = new Rectangle(0, 0, 10, 10);
        Rectangle r2 = new Rectangle(9, 9, 20, 20);
        assertTrue(r1.intersects(r2));
        assertTrue(r2.intersects(r1));
        r2 = new Rectangle(10, 10, 20, 20);
        assertTrue(r1.intersects(r2));
        assertTrue(r2.intersects(r1));
        r2 = new Rectangle(11, 11, 20, 20);
        assertFalse(r1.intersects(r2));
        assertFalse(r2.intersects(r1));
        r2 = new Rectangle(5, 5, 0, 0);
        assertTrue(r1.intersects(r2));
        assertTrue(r2.intersects(r1));
        r2 = new Rectangle (-5, 11, 1000, 1000);
        assertFalse(r1.intersects(r2));
        assertFalse(r2.intersects(r1));

        assertTrue(r1.intersects(r1));

    }


}
