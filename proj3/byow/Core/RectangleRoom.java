package byow.Core;

import byow.TileEngine.TETile;

import java.util.Random;

/**
 * Created by Carson Crow on 9/2/2022
 */
public class RectangleRoom implements Structure{

    public

    public RectangleRoom(TETile wall, TETile floor, )

    /** Returns an array of WorldTiles that the pseudorandomly generated structure consists of.
     * @param r an instance of Random for generating pseudorandom numbers
     * @param wall the material the structure's perimeter is made of
     * @param floor the material the structure's floor is made of
     * @param positions location data for where the structure should be
     *
     */
    @Override
    public WorldTile[] generate(Random r, TETile wall, TETile floor, Position... positions) {
        return new WorldTile[0];
    }
}
