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
    private final Random randy;
    private final List<Room> rooms;

    public RoomGenerator(Random r, Rectangle bounds, int minRoomSize, int maxRoomSize) {
        this.randy = r;
        this.bounds = bounds;
        this.minSize = minRoomSize;
        this.maxSize = maxRoomSize;
        rooms = new ArrayList<>();
    }

    public List<Room> generate(int n) {
        for (int i = 0; i < n; i += 1) {
            Room rm = generateRandomDistinctRoom();
            rooms.add(rm);
        }
        return rooms;
    }

    /** Helper function for generate(). Returns a pseudorandomly generated rectangular Room whose walls are within the bounds
     * Rectangle (inclusive), whose size is within this' given values, and which doesn't intersect any other rooms.
     */
    private Room generateRandomDistinctRoom() {

        Room rm = generateRandomRoom();

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

    private Room generateRandomRoom() {
        int roomWidth = RandomUtils.uniform(randy, minSize, maxSize + 1);
        int roomHeight = RandomUtils.uniform(randy, minSize, maxSize + 1);
        int roomX = RandomUtils.uniform(randy, bounds.origin().x, bounds.origin().x + bounds.width() - roomWidth);
        int roomY = RandomUtils.uniform(randy, bounds.origin().y, bounds.origin().y + bounds.height() - roomHeight);

        return new Room(new Position(roomX, roomY), roomWidth, roomHeight);
    }



}
