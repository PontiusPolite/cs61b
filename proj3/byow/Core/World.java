package byow.Core;

import byow.TileEngine.*;
import byow.Core.Room;
import byow.Core.RandomUtils;

import java.util.Random;

/**
 * Created by Carson Crow on 9/7/2022
 */
public class World {
    private final int width;
    private final int height;
    private final TETile ground;
    private final int NUM_ROOMS = 1;
    private final int MIN_ROOM_SIZE = 3;
    private final int MAX_ROOM_SIZE = 10;

    private final TETile[][] tiles;
    private Room[] rooms;

    public World(int width, int height, TETile ground) {
        this.width = width;
        this.height = height;
        this.ground = ground;
        tiles = new TETile[width][height];
        initialize();
    }

    public void initialize() {
        fillWorld(ground);
    }

    private void fillWorld(TETile tileType) {
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = tileType;
            }
        }
    }

    public TETile[][] getTiles() {
        return tiles;
    }

    public void generateRooms(Random r) {
        for (int i = 0; i < NUM_ROOMS; i += 1) {
            int w = RandomUtils.uniform(r, MIN_ROOM_SIZE, MAX_ROOM_SIZE + 1);
            int h = RandomUtils.uniform(r, MIN_ROOM_SIZE, MAX_ROOM_SIZE + 1);
            int x = RandomUtils.uniform()


        }
    }

    public void generateHallways(Random r) {

    }

    private Position getRandomWorldPosition(Random r) {
        return new Position(RandomUtils.uniform(r, width), RandomUtils.uniform(r, height));
    }

}
