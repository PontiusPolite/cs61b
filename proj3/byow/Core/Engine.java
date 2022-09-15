package byow.Core;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

import java.util.Random;

public class Engine {

    /* Feel free to change the width and height. */
    private static final int WIDTH = 80;
    private static final int HEIGHT = 30;

    private static TERenderer ter;
    private static World world;

    private static final Random r = new Random();

    /**
     * Method used for exploring a fresh world. This method should handle all inputs,
     * including inputs from the main menu.
     */
    public void interactWithKeyboard() {
    }

    /**
     * Method used for autograding and testing your code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The engine should
     * behave exactly as if the user typed these characters into the engine using
     * interactWithKeyboard.
     *
     * Recall that strings ending in ":q" should cause the game to quite save. For example,
     * if we do interactWithInputString("n123sss:q"), we expect the game to run the first
     * 7 commands (n123sss) and then quit and save. If we then do
     * interactWithInputString("l"), we should be back in the exact same state.
     *
     * In other words, both of these calls:
     *   - interactWithInputString("n123sss:q")
     *   - interactWithInputString("lww")
     *
     * should yield the exact same world state as:
     *   - interactWithInputString("n123sssww")
     *
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] interactWithInputString(String input) {
        // TODO: Fill out this method so that it run the engine using the input
        // passed in as an argument, and return a 2D tile representation of the
        // world that would have been drawn if the same inputs had been given
        // to interactWithKeyboard().
        //
        // See proj3.byow.InputDemo for a demo of how you can make a nice clean interface
        // that works for many different input types.

        InputSource stringInput = new StringInputSource(input);

        while (stringInput.hasNext()) {
            char c =  stringInput.next();

            if (c == 'n' || c == 'N') {
                // TODO: create new world
            }
            if (c == 'l' || c == 'L') {
                // TODO: load world
            }
            if (c == 'q' || c == 'Q') {
                // TODO: save world and quit program
            }

        }

        TETile[][] finalWorldFrame = null;
        return finalWorldFrame;
    }

    private static void initializeRenderer() {
        ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
    }

    public static void main(String[] args) {
        initializeRenderer();

        world = new World(WIDTH, HEIGHT, Tileset.NOTHING);

        world.generateRooms(r);
        world.generateHallways(r);

        ter.renderFrame(world.getTiles());
    }



}
