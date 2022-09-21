package byow.Core;

import byow.TileEngine.TETile;

import java.util.Random;

/**
 * Created by Carson Crow on 9/18/2022
 */
public class Hallway {

    private final Random randy;
    private final Rectangle[] bounds;
    private final int size;
    private final Position start;
    private final Position end;
    private TETile floor;
    private TETile wall;
    private int numSegments;


    public Hallway(Random r, Position start, Position end, int width) {
        this.randy = r;
        this.start = start;
        this.end = end;
        this.size = width;

        Position[] path = generateSimplePath();
        bounds = generateBounds(path);
    }

    /** Picks a random position in each room as the respective start and end of the hallway. */
    public Hallway(Random r, Room start, Room end, int width) {
        this.randy = r;
        this.start = start.getRandomInsidePoint(r);
        this.end = end.getRandomInsidePoint(r);
        this.size = width;

        Position[] path = generateSimplePath();
        bounds = generateBounds(path);

    }

    /** Returns an L-shaped path between start and end with 3 points. If the points are co-linear
     * vertically or horizontally, it will be a straight line. The direction of the path is randomized. */
    private Position[] generateSimplePath() {
        Position[] path = new Position[3];
        path[0] = start;
        path[2] = end;
        // randomize whether path starts in vertical or horizontal direction
        boolean coin = RandomUtils.bernoulli(randy);
        if (coin) {
            path[1] = new Position(start.x, end.y);
        } else {
            path[1] = new Position(end.x, start.y);
        }
        return path;
    }

    private Rectangle[] generateBounds(Position[] path) {
        Rectangle[] bounds = new Rectangle[path.length - 1];
        for (int i = 0; i < path.length - 1; i += 1) {
            Position current = path[i];
            Position next = path[i + 1];
            bounds[i] = getBoundSegment(current, next);
        }
        return bounds;
    }

//    private Position[] generatePath(Position start, Position end) {
//        // TODO: one way to generate a path might be to 'pathfind' from the start to the end after
//        // assigning random weights to each tile, or group of tiles.
//
//        // TODO: this algo will always move towards the end. Could we add a little randomness to maybe do loops?
//        // Keep in mind the numTurns might not be consistent.
//        Position[] path = new Position[bounds.length + 1];
//        path[0] = start;
//        boolean moveHorizontal = RandomUtils.bernoulli(randy);
//
//
//        path[bounds.length] = end;
//
//        return path;
//    }

    /** Returns the bounding Rectangle of the hallway segment between the two positions. **/
    private Rectangle getBoundSegment(Position current, Position next) {
        if (current.x == next.x) {
            return createVerticalBoundSegment(current, next);
        }
        return createHorizontalBoundSegment(current, next);

    }

    private Rectangle createVerticalBoundSegment(Position current, Position next) {
        int x = current.x - Math.floorDiv(this.size, 2);
        int y = (current.y <= next.y) ? current.y - 1 : current.y + 2;
        int w = this.size;
        int h = (current.y <= next.y) ? next.y - current.y + 2 : next.y - current.y - 2;
        return new Rectangle(x, y, w, h);
    }

    private Rectangle createHorizontalBoundSegment(Position current, Position next) {
        int x = (current.x <= next.x) ? current.x - 1 : current.x + 2;
        int y = current.y - Math.floorDiv(this.size, 2);
        int w = (current.x <= next.x) ? next.x - current.x + 2 : next.x - current.x - 2;
        int h = this.size;
        return new Rectangle(x, y, w, h);
    }

    public Rectangle[] getSegments() {
        return bounds;
    }
}
