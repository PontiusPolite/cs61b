package byow.Core;

import byow.TileEngine.TETile;

import java.util.Random;

/**
 * Created by Carson Crow on 9/15/2022
 *
 * A superclass for various shapes of Rooms. This class is a rectangular room,
 *
 */
public class Room {

    private Rectangle bounds;
    private TETile floor;
    private TETile wall;

    public Room(Position p, int w, int h) {
        bounds = new Rectangle(p, w, h);
    }

    public Room(Rectangle location) {
        bounds = location;
    }

    public int x() {
        return bounds.origin().x;
    }

    public int y() {
        return bounds.origin().y;
    }

    public int width() {
        return bounds.width();
    }

    public int height() {
        return bounds.height();
    }

    public Rectangle bounds() { return bounds; }

}
