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

    private Position position;
    private int width;
    private int height;
    private TETile wall;
    private TETile floor;

    public Room(Position p, int w, int h, TETile wallTile, TETile floorTile) {
        this.position = p;
        this.width = w;
        this.height = h;
        this.wall = wallTile;
        this.floor = floorTile;
    }



}
