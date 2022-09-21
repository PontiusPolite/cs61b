package byow.Core;

import byow.TileEngine.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Carson Crow on 9/7/2022
 */
public class RoomWorld implements World, Serializable {
    private final int NUM_ROOMS = 5;
    private final int MIN_ROOM_SIZE = 5;
    private final int MAX_ROOM_SIZE = 10;
    private final int NUM_HALLWAYS = 5;
    private final int HALLWAY_SIZE = 3;
    private final TETile GROUND_TILE = Tileset.GRASS;
    private final TETile WALL_TILE = Tileset.WALL;
    private final TETile FLOOR_TILE = Tileset.FLOOR;

    private static Random randy;

    private final Position ORIGIN = new Position(0, 0);
    private final Rectangle dimensions;

    private final TETile[][] tiles;
    private List<Room> rooms;
    private List<Hallway> hallways;


    public RoomWorld(long seed, int width, int height) {
        dimensions = new Rectangle(ORIGIN, width, height);
        randy = new Random();
        randy.setSeed(seed);
        rooms = new ArrayList<>();
        hallways = new ArrayList<>();
        tiles = generate();
    }

    public TETile[][] generate() {
        TETile[][] tiles = new TETile[this.dimensions.width()][this.dimensions.height()];
        for (TETile[] column : tiles) {
            Arrays.fill(column, GROUND_TILE);
        }

        RoomGenerator roomGen = new RoomGenerator(randy, this.dimensions, MIN_ROOM_SIZE, MAX_ROOM_SIZE);
        rooms = roomGen.generate(NUM_ROOMS);
        addRoomsToTiles(rooms, tiles);

        HallwayGenerator hallGen = new HallwayGenerator(randy, rooms, HALLWAY_SIZE);
        hallways = hallGen.generate(NUM_HALLWAYS);
        addHallwaysToTiles(hallways, tiles);


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
                boolean shouldBeWall = room.bounds().hasPointOnEdge(i, j);
                if (shouldBeWall) {
                    tiles[i][j] = WALL_TILE;
                } else {
                    tiles[i][j] = FLOOR_TILE;
                }

            }
        }
    }

    private void addHallwaysToTiles(List<Hallway> hallways, TETile[][] tiles) {
        for (Hallway h : hallways) {
            addHallwayToTiles(h, tiles);
        }
    }

    private void addHallwayToTiles(Hallway h, TETile[][] tiles) {
        for (int i = 0; i < h.getSegments().length; i += 1) {
            Rectangle s = h.getSegments()[i];
            addHallwaySegmentToTiles(s, tiles);
        }
    }

    private void addHallwaySegmentToTiles(Rectangle segment, TETile[][] tiles) {
        for (int i = segment.x(); i < segment.x() + segment.width(); i += 1) {
            for (int j = segment.y(); j < segment.y() + segment.height(); j += 1) {
                if (validateCoordinates(i, j)) {
                    boolean shouldBeWall = segment.hasPointOnEdge(i, j) && tiles[i][j] != FLOOR_TILE;
                    if (shouldBeWall) {
                        tiles[i][j] = WALL_TILE;
                    } else {
                        tiles[i][j] = FLOOR_TILE;
                    }

                }
                //tiles[i][j] = Tileset.WATER;
            }
        }
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
