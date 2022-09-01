package byow.Core;
import byow.TileEngine.TETile;

/**
 * Created by Carson Crow on 9/1/2022
 */
public class Tile {
    private Position pos;
    private TETile type;

    public Tile(int x, int y, TETile type) {
        pos = new Position(x, y);
        this.type = type;
    }


}
