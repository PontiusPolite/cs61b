package byow.Core;

import java.util.Random;
import byow.TileEngine.TETile;

/**
 * Created by Carson Crow on 9/2/2022
 *
 * Interface for describing all structures (halls and rooms for now).
 *
 */
public interface Structure {
    /** Returns an array of WorldTiles that the pseudorandomly generated structure consists of.
     * @param r an instance of Random for generating pseudorandom numbers
     * @param wall the material the structure's perimeter is made of
     * @param floor the material the structure's floor is made of
     * @param positions location data for where the structure should be
     *
     */
    public WorldTile[] generate(Random r, TETile wall, TETile floor, Position... positions);
}
