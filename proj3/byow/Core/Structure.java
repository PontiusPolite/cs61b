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
    /** Returns an array of StructureTiles (which are Position, TETile pairs) that the
     * pseudorandomly generated structure consists of.
     * Other attributes of the structure are determined by the specific instance.
     * @param r an instance of Random for generating pseudorandom numbers
     */
    public StructureTile[] generate(Random r);
}
