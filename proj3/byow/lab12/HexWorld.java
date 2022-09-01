package byow.lab12;
import org.junit.Test;
import static org.junit.Assert.*;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    public static final int WIDTH = 80;
    public static final int HEIGHT = 80;
    public static final Random r = new Random();

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];

        fillWorld(world, Tileset.NOTHING);
        addHexagonTessellation(40, 40, 5, 3, world, Tileset.GRASS);

        ter.renderFrame(world);
    }


    private static void addHexagonTessellation(int x, int y, int size, int hexSize, TETile[][] world, TETile tile) {
        int colSize = 2 * size - 1;
        addHexagonColumn(x, y, hexSize, colSize, world, tile);
        colSize -= 1;
        int colWidth = 2 * hexSize - 1;
        for (int i = 1; i < size; i += 1) {
            addHexagonColumn(x + i * colWidth, y, hexSize, colSize, world, tile);
            addHexagonColumn(x - i * colWidth, y, hexSize, colSize, world, tile);
            colSize -= 1;
        }
    }
    /** Adds a column of tessellated hexagons centered on x, y. */
    private static void addHexagonColumn(int x, int y, int hexSize, int columnSize, TETile[][] world, TETile tile) {
        if (columnSize == 0) return;
        if (columnSize == 1) {
            addHexagon(x, y, hexSize, world, tile);
            return;
        }
        int radius = (columnSize - 1) * hexSize;
        addHexagon(x, y + radius, hexSize, world, tile);
        addHexagonColumn(x, y, hexSize, columnSize - 2, world, tile);
        addHexagon(x, y - radius, hexSize, world, tile);
    }

    private static void addHexagon(int x, int y, int size, TETile[][] world, TETile tile) {
        // the y coord is the bottom middle row
        // the x coord is the left middle column if size is even
        if (size == 0) return;
        int rowWidth = 3 * size - 2;
        TETile t = TETile.colorVariant(tile, 255, 255, 255, r);
        for (int i = 0; i < size; i += 1) {
            addRow(x, y - i, rowWidth, world, t);
            addRow(x, y + i + 1, rowWidth, world, t);
            rowWidth -= 2;
        }
    }

    /** Adds a horizontal line of tiles centered on (x, y) with the given length. */
    private static void addRow(int x, int y, int length, TETile[][] world, TETile tile) {
        if (length == 0)  return;
        int start = x - Math.floorDiv(length - 1, 2);
        int end = x + Math.floorDiv(length, 2);
        for (int i = start; i <= end; i += 1) {
            if (validateCoordinates(i, y)) {
                world[i][y] = tile;
            }
        }
    }

    private static boolean validateCoordinates(int x, int y) {
        return (x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT);
    }

    private static void fillWorld(TETile[][] world, TETile tile) {
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = tile;
            }
        }
    }


}
