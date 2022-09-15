package byow.Core;

import byow.TileEngine.TETile;

/**
 * Created by Carson Crow on 9/2/2022
 *
 * A StructureTile attaches a Position to a TETile.
 */
public class StructureTile{

    private Position position;
    private TETile teTile;

    public StructureTile(Position p, TETile t) {
        this.position = p;
        this.teTile = t;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getX() {
        return this.position.x;
    }

    public int getY() {
        return this.position.y;
    }
}
