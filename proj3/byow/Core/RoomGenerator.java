package byow.Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Carson Crow on 9/16/2022
 *
 * A class responsible for creating distinct rectangular rooms within a given coordinate bounds.
 *
 */
public class RoomGenerator {

    private final Rectangle bounds;
    private final int minSize;
    private final int maxSize;
    private final Random r;
    private final List<Room> rooms;

    public RoomGenerator(Random r, Rectangle bounds, int minRoomSize, int maxRoomSize) {
        this.r = r;
        this.bounds = bounds;
        this.minSize = minRoomSize;
        this.maxSize = maxRoomSize;
        rooms = new ArrayList<>();
    }

    public List<Room> generateRooms(int n) {
        for (int i = 0; i < n; i += 1) {
            Room rm = generateRandomDistinctRoom();
            // TODO: check if this Room intersects with any others in rooms. If so, try again.
            // Brute force solution, come up with something better?
            rooms.add(rm);
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

        boolean isDistinct = true;

        for (Room r : this.rooms) {
            if (rm.bounds().intersects(r.bounds())){
                isDistinct = false;
            }
        }

        if (isDistinct) {
            return rm;
        }

        return generateRandomDistinctRoom();
    }



}
