package byow.Core;

import java.util.Random;

/**
 * Created by Carson Crow on 9/16/2022
 *
 * A class responsible for creating distinct rectangular rooms within a given coordinate bounds.
 *
 */
public class RoomGenerator {

    private final Rectangle bounds;
    private int minSize;
    private int maxSize;
    private final Random r;

    public RoomGenerator(Random r, Rectangle bounds, int minRoomSize, int maxRoomSize) {
        this.r = r;
        this.bounds = bounds;
        this.minSize = minRoomSize;
        this.maxSize = maxRoomSize;
    }

    public Room[] generateRooms(int n) {
        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i += 1) {
            Room rm = generateRandomDistinctRoom();
            // TODO: check if this Room intersects with any others in rooms. If so, try again.
            // Brute force solution, come up with something better?
            rooms[i] = rm;
        }
        return rooms;
    }

    /** Helper function for generateRooms. Returns a pseudorandomly generated rectangular Room whose walls are within the bounds
     * Rectangle (inclusive) and whose size is within this' given values.
     */
    private Room generateRandomDistinctRoom() {
        int roomWidth = RandomUtils.uniform(r, minSize, maxSize + 1);
        int roomHeight = RandomUtils.uniform(r, minSize, maxSize + 1);

        int roomX = RandomUtils.uniform(r, bounds.origin().x, bounds.origin().x + bounds.width() - roomWidth);
        int roomY = RandomUtils.uniform(r, bounds.origin().y, bounds.origin().y + bounds.height() - roomHeight);

        Position roomPosition = new Position(roomX, roomY);

        Room rm = new Room(roomPosition, roomWidth, roomHeight);

        return rm;
    }



}
