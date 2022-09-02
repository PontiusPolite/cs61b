package byow.Core;

import byow.TileEngine.TETile;

/**
 * Created by Carson Crow on 9/2/2022
 */
public class WorldTile {

    private Position position;
    private TETile type;

    public WorldTile(Position p, TETile t) {
        this.position = p;
        this.type = t;
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
