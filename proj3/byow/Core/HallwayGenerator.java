package byow.Core;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Carson Crow on 9/18/2022
 */
public class HallwayGenerator {

    private List<Room> queue;
    private List<Hallway> hallways;
    private final Random randy;
    private int hallwaySize;

    public HallwayGenerator(Random r, List<Room> rooms, int hallwaySize) {
        this.randy = r;
        this.queue = shuffleIntoQueue(rooms);
        this.hallwaySize = hallwaySize;
        hallways = new ArrayList<>();
    }

    public List<Hallway> generate(int n) {
        List<Hallway> hallways = new ArrayList<>();
        for (int i = 0; i < n; i += 1) {
            // TODO: randomize hallway thickness and number of turns
            // TODO: randomize whether we connect to a room, or to a hallway we've already generated.
            int numTurns = 1;
            Hallway h = new Hallway(randy, queue.get(0), queue.get(1), this.hallwaySize);
            hallways.add(h);
            moveFirstRoomToEnd();
        }
        return hallways;
    }

    private List<Room> shuffleIntoQueue(List<Room> rooms) {
        List<Room> shuffled = new ArrayList<>();
        List<Room> copy = new ArrayList<>();
        copy.addAll(rooms);
        while(copy.size() > 0) {
            int pick = randy.nextInt(copy.size());
            shuffled.add(copy.remove(pick));
        }
        return shuffled;
    }

    private void moveFirstRoomToEnd() {
        Room first = queue.remove(0);
        queue.add(first);
    }

}
