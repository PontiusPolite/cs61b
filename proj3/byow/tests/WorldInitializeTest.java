package byow.tests;

import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;
import org.junit.Test;

import byow.Core.World;
import static org.junit.Assert.*;

/**
 * Created by Carson Crow on 9/15/2022
 */
public class WorldInitializeTest {

    @Test
    public void testBlankWorld() {
        TETile background = Tileset.NOTHING;

        World w = new World(10, 10, background);
        w.initialize();
        TETile[][] t = w.getTiles();
        assertEquals(t[0][0], background);
        assertEquals(t[9][0], background);
        assertEquals(t[0][9], background);
        assertEquals(t[9][9], background);
    }
}
