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
    private Random randy;

    public HallwayGenerator(Random r, List<Room> rooms) {
        this.randy = r;
        this.queue = rooms;
        shuffleQueue;
        hallways = new ArrayList<>();
    }

    public List<Hallway> generate(int n) {
        for (int i = 0; i < n; i += 1) {
            // TODO: randomize hallway thickness and number of turns
            Hallway h = new Hallway(queue.get(0), queue.get(1));
            Room first = queue.remove(0);
            queue.add(first);
        }
    }

    private void

    private void shuffleQueue() {
        List<Room> shuffled = new ArrayList<>();
        for (int i = 0; i < queue.size(); i += 1) {
            int pick = randy.nextInt(queue.size());
            shuffled.add(queue.remove(pick));
        }
        queue = shuffled;
    }

}
