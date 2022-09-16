package byow.Core;

import byow.TileEngine.TETile;

/**
 * Created by Carson Crow on 9/15/2022
 */
public interface World {

    /** Returns the 2d array of tiles that serves as the world data for rendering.
     * These tiles are null until generate() is called.
     * */
    public TETile[][] getTiles();

    /** Fills all tiles in the World with the specified tileType. */
    public void fillWorld(TETile tileType);

    /** Fills tiles pseudorandomly to create the starting state of the World. */
    public TETile[][] generate();

    public int width();

    public int height();

    /** Returns true if p is within the bounds of the World instance. */
    public boolean validatePosition(Position p);

    /** Returns true if (x, y) is within the bounds of the World instance. */
    public boolean validateCoordinates(int x, int y);

}