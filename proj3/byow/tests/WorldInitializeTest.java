package byow.tests;

import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;
import org.junit.Test;

import byow.Core.RoomWorld;
import static org.junit.Assert.*;

/**
 * Created by Carson Crow on 9/15/2022
 */
public class WorldInitializeTest {

    @Test
    public void testBlankWorld() {

        RoomWorld w = new RoomWorld(1, 10, 10);
        w.fillWorld(Tileset.NOTHING);
        TETile[][] t = w.getTiles();
        assertEquals(t[0][0], Tileset.NOTHING);
        assertEquals(t[9][0], Tileset.NOTHING);
        assertEquals(t[0][9], Tileset.NOTHING);
        assertEquals(t[9][9], Tileset.NOTHING);
    }
}
