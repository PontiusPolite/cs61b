package byow.Core;

import byow.TileEngine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Carson Crow on 9/7/2022
 */
public class RoomWorld implements World{
    private final int NUM_ROOMS = 20;
    private final int MIN_ROOM_SIZE = 4;
    private final int MAX_ROOM_SIZE = 8;
    private final TETile GROUND_TILE = Tileset.GRASS;
    private final TETile WALL_TILE = Tileset.WALL;
    private final TETile FLOOR_TILE = Tileset.FLOOR;

    private static Random randy;

    private final Position ORIGIN = new Position(0, 0);
    private final Rectangle dimensions;

    private final TETile[][] tiles;
    private List<Room> rooms;


    public RoomWorld(long seed, int width, int height) {
        dimensions = new Rectangle(ORIGIN, width, height);
        System.out.println(seed);
        randy = new Random();
        randy.setSeed(seed);
        rooms = new ArrayList<>();
        tiles = generate();
    }

    public TETile[][] generate() {
        TETile[][] tiles = new TETile[this.dimensions.width()][this.dimensions.height()];
        for (TETile[] column : tiles) {
            Arrays.fill(column, GROUND_TILE);
        }

        RoomGenerator roomGen = new RoomGenerator(randy, this.dimensions, MIN_ROOM_SIZE, MAX_ROOM_SIZE);
        rooms = roomGen.generateRooms(NUM_ROOMS);

        addRoomsToTiles(rooms, tiles);

        return tiles;
    }

    @Override
    public int width() {
        return this.dimensions.width();
    }

    @Override
    public int height() {
        return this.dimensions.height();
    }



    @Override
    public void fillWorld(TETile tileType) {
        for (int x = 0; x < dimensions.width(); x += 1) {
            for (int y = 0; y < dimensions.height(); y += 1) {
                tiles[x][y] = tileType;
            }
        }
    }

    @Override
    public TETile[][] getTiles() {
        return tiles;
    }


    private void addRoomsToTiles(List<Room> rooms, TETile[][] tiles) {
        for (Room rm : rooms) {
            addRoomToTiles(rm, tiles);
        }
    }

    private void addRoomToTiles(Room room, TETile[][] tiles) {
        for (int i = room.x(); i < room.x() + room.width(); i += 1) {
            for (int j = room.y(); j < room.y() + room.height(); j += 1) {
                boolean shouldBeWall = (i == room.x() || i == room.x() + room.width() - 1);
                shouldBeWall = shouldBeWall || (j == room.y() || j == room.y() + room.height() - 1);
                if (shouldBeWall) {
                    tiles[i][j] = WALL_TILE;
                } else {
                    tiles[i][j] = FLOOR_TILE;
                }

            }
        }
    }

    /** Returns a random Position with coordinates between the given bounds (inclusive of both). */
    private Position randomPosition(Random r, int minX, int maxX, int minY, int maxY) {
        int x = RandomUtils.uniform(r, minX, maxX + 1);
        int y = RandomUtils.uniform(r, minY, maxY + 1);
        return new Position(x, y);
    }

    public void generateHallways(Random r) {

    }

    /** Returns true if p is within the bounds of the World instance. */
    @Override
    public boolean validatePosition(Position p) {
        return (p.x >= 0 && p.x < dimensions.width()) && (p.y >= 0 && p.y < dimensions.height());

    }

    /** Returns true if (x, y) is within the bounds of the World instance. */
    @Override
    public boolean validateCoordinates(int x, int y) {
        return (x >= 0 && x < dimensions.width()) && (y >= 0 && y < dimensions.height());

    }


}
